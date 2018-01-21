
# SwipeBack
侧滑返回



Step 1. Add the dependency

    <dependency>
        <groupId>com.tsinling.swipeback</groupId>
        <artifactId>swipeback</artifactId>
        <version>1.0.0</version>
        <type>pom</type>
    </dependency>

    or
	dependencies {
	        compile 'com.tsinling.swipeback:swipeback:1.0.0'
	}

thanks for SwipeBackLayout (https://github.com/gongwen/SwipeBackLayout)

对SwipeBackLayout做了如下修改：

1. 微信样式需要的Activity堆栈管理用了弱引用，减少内存溢出的机会

2. ActivityStack 仅仅提供ActivityStack的记录，若有需求则可以利用提供的 getStack（）方法获取堆栈信息，然后基于该类进行逻辑处理

用法 ：
  SwipeBackLayout介绍已经很详细  特别注意：

  无论你选择什么主题。那必须有

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


   也可以这样

      public class App extends Application {
          @Override
          public void onCreate() {
              super.onCreate();
              //若是需要微信风格 则需要init
              //在debug版本，若使用微信风格但未init 则会报异常
              //在release版本，若设置了微信风格但未init 则仅仅会没有微信侧滑效果

              ActivityStack.getInstance().init(this);

              //若是不想在Base类里面设置 则可以参考SwipeBackHelper 的使用方法
              SwipeBackHelper.getInstance().init(this);
          }
      }


      public class SwipeBackHelper extends ActivityLifecycleCallbacks {

          private SwipeBackHelper(){}
          private static class SingletonHolder {
              private static final SwipeBackHelper mInstance = new SwipeBackHelper();
          }

          public static SwipeBackHelper getInstance() {
              return SwipeBackHelper.SingletonHolder.mInstance;
          }

          public void init(Application mApplication) {
              mApplication.registerActivityLifecycleCallbacks(this);
          }


          @Override
          public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

              if (!(activity instanceof MainActivity)) {//跳过MainActivity

                  SwipeBackLayout mSwipeBackLayout = new SwipeBackLayout(activity);
                  mSwipeBackLayout.attachToActivity(activity);
                  mSwipeBackLayout.setWeChatStyle(false);//若开启该功能，需要在Application里init
              }
          }

      }


  最后

  与StatusBarUtil 配合使用更美哟！  https://github.com/laobie/StatusBarUtil