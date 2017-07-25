package net.alhazmy13.mediagallery;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.widget.LinearLayout;

import net.alhazmy13.mediagallery.library.activity.MediaGallery;
import net.alhazmy13.mediagallery.library.views.MediaGalleryView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MediaGalleryView.OnImageClicked {
    ArrayList<String> list;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = getFakeList();

        MediaGalleryView view = (MediaGalleryView) findViewById(R.id.gallery);
        view.setImages(list);
        view.setOnImageClickListener(this);
        view.setPlaceHolder(R.drawable.media_gallery_placeholder);
        view.setOrientation(MediaGalleryView.HORIZONTAL);
//        view.setImageSize(500,MediaGalleryView.DEFAULT);
        view.notifyDataSetChanged();



    }

    private ArrayList getFakeList() {
        ArrayList<String> imagesList = new ArrayList<>();
        Bitmap image = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
        image.eraseColor(android.graphics.Color.GREEN);
        imagesList.add(bitMapToString(image));
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/12/23193634/tumblr_oiboua3s6F1slhhf0o1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/11/08192732/tumblr_oev1qbnble1ted1sho1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/11/18184202/tumblr_ntyttsx2Y51ted1sho1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/11/25093310/2016-03-01-roman-drits-barnimages-008-768x512.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/11/25093310/2016-03-01-roman-drits-barnimages-008-768x512.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/11/25093331/tumblr_ofz20toUqd1ted1sho1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/11/25093334/2016-11-21-roman-drits-barnimages-003-768x512.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/11/02093356/DSF1919-768x512.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/11/02093347/2016-11-21-roman-drits-barnimages-009-768x512.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/12/16094158/2016-12-05-roman-drits-barnimages-011-768x512.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/12/16094159/tumblr_o2z8oh0Ntt1ted1sho1_1280-683x1024.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/12/23193617/2016-11-13-barnimages-igor-trepeshchenok-01-768x509.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/11/08192739/tumblr_ofem6n49F61ted1sho1_500.jpg");
        return imagesList;
    }


    @Override
    public void onImageClicked(int pos) {
        MediaGallery.Builder(this,list)
                .title("Media Gallery")
                .backgroundColor(R.color.white)
                .placeHolder(R.drawable.media_gallery_placeholder)
                .selectedImagePosition(pos)
                .show();
    }

    public String bitMapToString(Bitmap bitmap){
        ByteArrayOutputStream baos=new  ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100, baos);
        byte [] b=baos.toByteArray();
        return Base64.encodeToString(b, Base64.DEFAULT);
    }
}
