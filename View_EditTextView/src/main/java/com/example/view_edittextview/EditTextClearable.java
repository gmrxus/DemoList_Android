package com.example.view_edittextview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

/**
 * Created by mrxus on 16/7/12.
 */
public class EditTextClearable extends EditText {

    private Drawable mRightDrawable;

    public EditTextClearable(Context context) {
        super(context);
        init();
    }

    public EditTextClearable(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EditTextClearable(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        //获取右侧图标引用(顺序:左[0]上[1]右[2]下[3])
        mRightDrawable = getCompoundDrawables()[2];

        //添加焦点变化监听
        this.setOnFocusChangeListener(new FocusChangeListenerImpl());
        //添加文字变化监听
        this.addTextChangedListener(new TextWatcherImpl());
        //设置右侧图片不可见
        setClearDrawableVisible(false);
    }

    private void setClearDrawableVisible(boolean isVisible) {
        Drawable drawable;
        if (isVisible) {
            drawable = mRightDrawable;
        } else {
            drawable = null;
        }
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], drawable, getCompoundDrawables()[3]);

    }

    private class FocusChangeListenerImpl implements OnFocusChangeListener {

        private boolean isVisible;

        @Override
        public void onFocusChange(View view, boolean b) {
            //获得焦点后,如果内容长度大于1,显示删除图标
            if (b) {
                isVisible = getText().toString().length() > 1;
            } else {
                isVisible = false;
            }
            setClearDrawableVisible(isVisible);


        }
    }

    private class TextWatcherImpl implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            //内容改变后,如果长度大于1,显示删除图标
            boolean isVisible = getText().toString().length() > 1;
            setClearDrawableVisible(isVisible);
        }
    }

    //用于监听手指抬起时的位置,如果在清除图标上就清除文字
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                boolean isClear = event.getX() > (getWidth() - getTotalPaddingRight()) && event.getX() < (getWidth() - getPaddingRight());
                if (isClear) {
                    setText("");
                }
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }
}
