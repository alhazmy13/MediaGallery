
# Media Gallery
![](https://img.shields.io/badge/Platform-Android-brightgreen.svg)
![](https://img.shields.io/packagist/l/doctrine/orm.svg)
![](https://img.shields.io/badge/version-0.1.0_beta-blue.svg)

------

## Screenshots 
<img src="https://cloud.githubusercontent.com/assets/4659608/22867461/c77d039e-f199-11e6-8be6-027ae6e7af75.gif" width="300" align="center">


## Installation

**Maven**

```xml
<dependency>
  <groupId>net.alhazmy13.mediagallery</groupId>
  <artifactId>library</artifactId>
  <version>0.1.1-beta</version>
  <type>pom</type>
</dependency>
```


**Gradle**

```gradle

repositories {
   maven { url "https://jitpack.io" }
}

dependencies {
	compile 'net.alhazmy13.mediagallery:library:0.1.1-beta'
}
```

## MeidaGallery Activity  

```java
        MediaGallery.Builder(this,list)
                .title("Title")
                .backgroundColor(R.color.colorAccent)
                .placeHolder(R.drawable.placeholder)
                .selectedImagePosition(1)
                .show();
```



## MeidaGallery View
 
```java
<net.alhazmy13.mediagallery.library.views.MediaGalleryView
    android:id="@+id/gallery"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:place_holder="@drawable/placeholder"
    app:span_count="3" />

```

And from your activity :

```java
        MediaGalleryView view = (MediaGalleryView) findViewById(R.id.gallery);
        view.setImages(list);
        view.setOnImageClickListener(this);
        view.notifyDataSetChanged();

```

