package com.veryworks.android.customview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * 커스텀뷰 만들기
 * 1. 커스텀 속성을 attrs.xml 파일에 정의
 *
 * 2. 커스텀할 객체(위젯)를 상속받은 후 재정의
 *
 * 3. 커스텀한 위젯을 레이아웃.xml에서 태그로 사용
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
