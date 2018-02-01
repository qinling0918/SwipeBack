
# SwipeBack
   侧滑返回



Step 1. Add the dependency

 	dependencies {
 	        implementation 'com.tsinling.swipeback:swipeback:1.0.0'
 	}


   if  Failed to resolve: com.tsinling.swipeback:library:1.0.0

   Please copy the following to your project gradle file

    repositories {
            maven {
                url  "https://dl.bintray.com/tsinling/maven"
                }
           }




thanks  for  [SwipeBackLayout](https://github.com/gongwen/SwipeBackLayout)


#### 对SwipeBackLayout做了如下修改：

>1. 微信样式需要的Activity堆栈管理用了弱引用，减少内存溢出的机会
>2. ActivityStack 仅仅提供ActivityStack的记录，若有需求则可以利用提供的 getStack（）方法获取堆栈信息，然后基于该类进行逻辑处理

用法 ：
  SwipeBackLayout介绍已经很详细  特别注意：

  无论你选择什么主题。那必须有

     <item name="android:windowIsTranslucent">true</item>
     <item name="android:windowBackground">@android:color/transparent</item>

例如

        <!-- <style name="AppTheme" parent="Theme.SwipeBack.NoActionBar">-->
          <style name="AppTheme" parent="Theme.AppCompat.Light">
              <item name="colorPrimary">@color/colorPrimary</item>
              <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
              <item name="colorAccent">@color/colorAccent</item>

             <!--  swipeback 库里提供了 Theme.SwipeBack.NoActionBar 主题  若您不想用该主题，则必须在您的主题下进行如下设置-->
             <item name="android:windowIsTranslucent">true</item>
              <item name="android:windowBackground">@android:color/transparent</item>
          </style>

   你可以在这样用


      public class BaseActivity extends AppCompatActivity {
          @Override
          protected void onCreate(@Nullable Bundle savedInstanceState) {
              super.onCreate(savedInstanceState);

              attachSwipeToActivity();
          }

          private void attachSwipeToActivity() {

              if (!(this instanceof MainActivity)) {//跳过MainActivity
                  SwipeBackLayout mSwipeBackLayout = new SwipeBackLayout(this);
                  mSwipeBackLayout.attachToActivity(this);
                  mSwipeBackLayout.setWeChatStyle(true);//若开启该功能，需要在Application里init
              }
          }
      }


   也可以参考demo中 Application中的用法




#### 推荐:

  [与StatusBarUtil](https://github.com/laobie/StatusBarUtil) 配合使用更美哟！
  当然，这是用Activity实现的， 有fragment也可以实现, 推荐
  [Fragmentation]( https://github.com/YoKeyword/Fragmentation)
