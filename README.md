# Android Custom-Dialog
 
这是一个自定义封装好的dialog工具类。这样可以减少不必要的重复代码，从而使代码更加灵活简洁方便易用，希望你们喜欢，觉得不错的话可以Star，方便下次回来查看，当然也希望你们能够多多指教，互相学习。
 
 
## Demo
 
![](https://github.com/zsml2016/CustomDialogUtils/blob/master/dialog.gif?raw=true)

[Download Apk](https://github.com/zsml2016/CustomDialogUtils/releases/download/v1.0.1/demo101.apk)
 
## Usage

### Step 1

#### Gradle

```groovy
dependencies {
    	compile 'com.superluo:dialog:1.0.1'
}
```


#### Maven

```xml
<dependency>
  <groupId>com.superluo</groupId>
  <artifactId>dialog</artifactId>
  <version>1.0.1</version>
  <type>pom</type>
</dependency>
```



### Step 2

xml中创建自己想要实现的dialog布局，喜欢就好，哈哈。



### Step 3
 
接下来就可以通过简洁的代码调用封装好dialog工具类，实现你想要的效果了。

(1)简单调用：
 
```java
new CustomDialog.Builder(this)
                .view(R.layout.xxx)
                .build()
                .show();
```

(2)使用addViewOnclick(viewId, listener)方法添加view的点击监听：
 
```java
new CustomDialog.Builder(this)
                .view(R.layout.xxx)
                .addViewOnclick(R.id.xxx,listener)
                .build()
                .show();
```

(3)使用cancelTouchout(boolean)方法设置是否点击dialog背景取消dialog （默认为true）：
 
```java
new CustomDialog.Builder(this)
                .view(R.layout.xxx)
                .addViewOnclick(R.id.xxx,listener)
                .cancelTouchout(false)
                .build()
                .show();
```

(4)使用setDialogAnim(R.style.xxx)方法设置dialog进出动画：
 
```java
new CustomDialog.Builder(this)
                .view(R.layout.xxx)
                .addViewOnclick(R.id.xxx,listener)
                .cancelTouchout(false)
                .setDialogAnim(R.style.xxx)
                .build()
                .show();
```

(5)使用setDialogPosition(position)方法设置dialog在屏幕的显示位置 （默认为屏幕中间）：
 
```java
new CustomDialog.Builder(this)
                .view(R.layout.xxx)
                .addViewOnclick(R.id.xxx,listener)
                .cancelTouchout(false)
                .setDialogAnim(R.style.xxx)
                .setDialogPosition(xxx)
                .build()
                .show();
  ```
  
  (6)设置dialog宽高，默认宽为屏幕的0.7，高为包裹内容。下面提供了几种设置宽高的方法（调用方法如上）：
 
```java

setHeightPX(int val)//用px设置dialog高度
setWidthPX(int val)//用px设置dialog宽度

setHeightDP(int val)//用dp设置dialog高度
setWidthDP(int val)//用dp设置dialog宽度

setHeightDimenRes(int dimenRes)//用dimen设置dialog高度
setWidthDimenRes(int dimenRes)//用dimen设置dialog宽度

  ```
  
  (7)使用cancel()方法取消dialog显示：
 
```java
CustomDialog dialog = new CustomDialog.Builder(this)
                .view(R.layout.xxx)
                .addViewOnclick(R.id.xxx,listener)
                .cancelTouchout(false)
                .setDialogAnim(R.style.xxx)
                .setDialogPosition(xxx)
                .build();
                
        //dialog显示
        dialog.show();
        、、、
        //取消dialog显示
        dialog.cancel();
  ```
  
  (8)最后还可以使用获取控件实例的方法，以便在代码里设置控件的文本属性；
  ```java
  dialog = new CustomDialog.Builder(this)
                .view(R.layout.dialog_custom_view1)
                .addViewOnclick(R.id.tv_cancel,listener)
                .addViewOnclick(R.id.tv_update,listener)
                .build();
        //代码设置view属性
        TextView tv_title = dialog.findView(R.id.tv_title);
        TextView tips = dialog.findView(R.id.tv_tips);
        TextView tv_update = dialog.findView(R.id.tv_update);
        tv_title.setText("辞职信");
        tips.setText("由于程序猿这行业是高危行业，所以我决定明天就向老板申请离职，毕竟世界那么大，我还想活着去看看");
        tv_update.setText("立即辞职");

        dialog.show();
  ```
  
[Code example](https://github.com/zsml2016/CustomDialogUtils/blob/master/demo/src/main/java/com/zsml/customdialog/MainActivity.java)
 
 
