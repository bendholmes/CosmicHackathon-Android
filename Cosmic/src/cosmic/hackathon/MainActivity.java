package cosmic.hackathon;

import java.io.File;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import cosmic.hackathon.images.ColourDetector;
import cosmic.hackathon.images.Colours;
import cosmic.hackathon.models.Questionaire;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    private static final String TAG = "Cosmic";

	private static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100;
	private static final int MEDIA_TYPE_IMAGE = 1;

	private static final Questionaire questionaire = new Questionaire();

	private TextView questionTitle;
	private TextView chosenCardText;
	private ImageView chosenCardImage;
	private ImageView imgPreview;
	private ImageView questionImage;
	private Button retakePhotoButton;
	private Button nextQuestionButton;
	private View view1;
	private View view2;
	
	private Uri fileUri;
	
	private static final String IMAGE_DIRECTORY_NAME = "Hello Camera";
	
	private static boolean hasRetaken = false;
	
	private void nextQuestion() {
	    // TODO
	}
	
	private void captureImage() {
	    Log.d(TAG, "URI SET");
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
		startActivityForResult(intent, CAMERA_CAPTURE_IMAGE_REQUEST_CODE);
	}
	
	/**
	 * Creating file uri to store image/video
	 */
	public Uri getOutputMediaFileUri(int type) {
	    return Uri.fromFile(getOutputMediaFile(type));
	}
	 
	/**
	 * Return image / video
	 */
	private static File getOutputMediaFile(int type) {
	    // External sdcard location
	    File mediaStorageDir = new File(
	            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
	            IMAGE_DIRECTORY_NAME
	    );
	 
	    // Create the storage directory if it does not exist
	    if (!mediaStorageDir.exists()) {
	        if (!mediaStorageDir.mkdirs()) {
	            Log.d(TAG, "Oops! Failed create " + IMAGE_DIRECTORY_NAME + " directory");
	            return null;
	        }
	    }
	 
	    // Create a media file name
	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
	    File mediaFile;
	    if (type == MEDIA_TYPE_IMAGE) {
	        mediaFile = new File(mediaStorageDir.getPath() + File.separator + "IMG_" + timeStamp + ".jpg");
	    } else {
	        return null;
	    }
	 
	    return mediaFile;
	}
	
	private Bitmap getPhotoAsBitmap() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 8;
 
        return BitmapFactory.decodeFile(fileUri.getPath(), options);
	}
	
	private void previewCapturedImage(Bitmap bitmap) {
	    try {	  
	        imgPreview.setVisibility(View.VISIBLE);
	        imgPreview.setImageBitmap(bitmap);
	    } catch (NullPointerException e) {
	        e.printStackTrace();
	    }
	}
	
	public int[] getBitmapPixels(Bitmap bitmap) {
	    int[] pixels = new int[bitmap.getWidth() * bitmap.getHeight()];
	    bitmap.getPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
	    return pixels;
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
		    if (fileUri != null) {
    		    Toast.makeText(getApplicationContext(), "Image saved!", Toast.LENGTH_SHORT).show();
    
    		    Bitmap bitmap = getPhotoAsBitmap();
    		    
    		    // Set widgets
    		    questionImage.setVisibility(View.GONE);
    		    questionTitle.setText(questionaire.getNextQuestion().getQuestionText());
    		    questionTitle.setVisibility(View.VISIBLE);
    		    chosenCardText.setVisibility(View.VISIBLE);
    			retakePhotoButton.setVisibility(View.VISIBLE);
    			nextQuestionButton.setVisibility(View.VISIBLE);
    			view1.setVisibility(View.VISIBLE);
    			view2.setVisibility(View.VISIBLE);

                previewCapturedImage(bitmap);
    
    			int[] pixels = getBitmapPixels(bitmap);
    			int cardResource = questionaire.getNextQuestion().getChosenAnswerImage(pixels);
    			
    			if (cardResource != 0) {
    			    chosenCardImage.setImageResource(cardResource);
    			}
		    } else {
		        Toast.makeText(getApplicationContext(), "Failed to get image URI", Toast.LENGTH_SHORT).show();
		    }
		} else if (resultCode == RESULT_CANCELED) {
			Toast.makeText(getApplicationContext(), "User cancelled image capture", Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(getApplicationContext(), "Sorry! Failed to capture image", Toast.LENGTH_SHORT).show();
		}
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        questionTitle = (TextView)findViewById(R.id.questionTitle);
        chosenCardText = (TextView)findViewById(R.id.chosenCardText);
        chosenCardImage = (ImageView)findViewById(R.id.chosenCardImage);
        questionImage = (ImageView)findViewById(R.id.questionImage);
        questionImage.setImageResource(R.drawable.question1);
        imgPreview = (ImageView)findViewById(R.id.imgPreview);
        retakePhotoButton = (Button)findViewById(R.id.retakePhotoButton);
        nextQuestionButton = (Button)findViewById(R.id.nextQuestionButton);
        view1 = (View)findViewById(R.id.view1);
        view2 = (View)findViewById(R.id.view2);
 
        questionImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                captureImage();
            }
        });
 
        retakePhotoButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				captureImage();
			}
		});
		
        nextQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextQuestion();
            }
        });		
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (fileUri != null) {
            outState.putString("fileUri", fileUri.toString());
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("fileUri")) {
            fileUri = Uri.parse(savedInstanceState.getString("fileUri"));
        }
    }
}
