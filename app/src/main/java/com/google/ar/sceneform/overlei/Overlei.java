
package com.google.ar.sceneform.overlei;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.samples.Overlei.R;
import com.google.ar.sceneform.ux.ArFragment;

/**
 * At this point i have installed the google sceneform plugin. This is whats going to help be able to work with 3D assets
 */
public class Overlei extends AppCompatActivity {

  private ArFragment fragment;
  private String currentltySelectedObject;

  @Override
  protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);

    //brings up hand and camera to scan environment
    setContentView(R.layout.activity_ux);

    fragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.sceneform_fragment);

    initializeGallary();

    //printing selected object to dubug log
    fragment.setOnTapArPlaneListener ((HitResult hitResult, Plane plane, MotionEvent motionEvent) -> {

        Log.d("modelType", currentltySelectedObject);
      }
    );


  }

  public void initializeGallary(){

    LinearLayout gallary = findViewById(R.id.gallery_layout);

    //create chair thumbnails
    ImageView chair = new ImageView(this);
    chair.setImageResource(R.drawable.chair_thumb);
    chair.setContentDescription("chair asset");
    chair.setOnClickListener(view -> currentltySelectedObject = "chair");
    gallary.addView(chair);

    //create couch thumbnail
    //where im getting the image from
    ImageView couch = new ImageView(this);
    //imageView resource
    couch.setImageResource(R.drawable.couch_thumb);
    //attaching a description
    couch.setContentDescription("couch asset");
    //setting onclick action to set the currentlySelectedObject
    couch.setOnClickListener(view -> currentltySelectedObject = "couch");
    gallary.addView(couch);

    //lampPost thubnail
    ImageView lampPost = new ImageView(this);
    lampPost.setImageResource(R.drawable.lamp_thumb);
    lampPost.setContentDescription("lampPost asset");
    lampPost.setOnClickListener(view -> currentltySelectedObject="lampPost");
    gallary.addView(lampPost);
  }


  /**======================================COMMENTING STARTS HERE==================================================*/
//  private static final String TAG = Overlei.class.getSimpleName();
//  private static final double MIN_OPENGL_VERSION = 3.0;
//
//  private ArFragment arFragment;
//  private ModelRenderable andyRenderable;
//
//  @Override
//  @SuppressWarnings({"AndroidApiChecker", "FutureReturnValueIgnored"})
//  // CompletableFuture requires api level 24
//  // FutureReturnValueIgnored is not valid
//  protected void onCreate(Bundle savedInstanceState) {
//    super.onCreate(savedInstanceState);
//
//    if (!checkIsSupportedDeviceOrFinish(this)) {
//      return;
//    }
//
//    setContentView(R.layout.activity_ux);
//    arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.sceneform_fragment);
//
//  }
//
//  /**
//   * Returns false and displays an error message if Sceneform can not run, true if Sceneform can run
//   * on this device.
//   *
//   * <p>Sceneform requires Android N on the device as well as OpenGL 3.0 capabilities.
//   *
//   * <p>Finishes the activity if Sceneform can not run
//   */
//  public static boolean checkIsSupportedDeviceOrFinish(final Activity activity) {
//    if (Build.VERSION.SDK_INT < VERSION_CODES.N) {
//      Log.e(TAG, "Sceneform requires Android N or later");
//      Toast.makeText(activity, "Sceneform requires Android N or later", Toast.LENGTH_LONG).show();
//      activity.finish();
//      return false;
//    }
//    String openGlVersionString =
//            ((ActivityManager) activity.getSystemService(Context.ACTIVITY_SERVICE))
//                    .getDeviceConfigurationInfo()
//                    .getGlEsVersion();
//
//    if (Double.parseDouble(openGlVersionString) < MIN_OPENGL_VERSION) {
//      Log.e(TAG, "Sceneform requires OpenGL ES 3.0 later");
//      Toast.makeText(activity, "Sceneform requires OpenGL ES 3.0 or later", Toast.LENGTH_LONG)
//              .show();
//      activity.finish();
//      return false;
//    }
//    return true;
//  }

  /**===============================================COMMENTING ENDS HERE==============================================*/
}
