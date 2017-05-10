package com.hyunseok.android.fragmentcontrol;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ListFragment list;
    DetailFragment detail;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Fragment 생성
        list = new ListFragment();
        detail = new DetailFragment();

        list.setActivity(this);
        detail.setActivity(this);

        // 2. Fragment Manger 가져오기
        //getFragmentManager(); // 앱 호환성이 없는 함수(정상동작 안될 가능성있음)
        manager = getSupportFragmentManager(); // 앱 호환성이 있는 매니저 함수

        setList();

    }

    // Activity에 처음 목록이 세팅될 때
    public void setList() {

        // 3. Fragment를 실행하기 위한 Transaction(프로세스 처리 단위) 가져오기
        FragmentTransaction transaction = manager.beginTransaction();
        // 4. Fragment를 레이아웃에 add한다.
        transaction.add(R.id.fragment, list);
        // 5. Commit 전에 Transaction전체를 Stack에 저장
        transaction.addToBackStack(null);
        // 6. commit
        transaction.commit();

    }

    // List Fragment에서 Detail Fragment로 이동할 때
    public void goDetail() {
        // 3. Fragment를 실행하기 위한 Transaction(프로세스 처리 단위) 가져오기
        FragmentTransaction transaction = manager.beginTransaction();
        // 4. Fragment를 레이아웃에 add한다.
        transaction.add(R.id.fragment, detail);
        // 5. Commit 전에 Transaction전체를 Stack에 저장
        transaction.addToBackStack(null);
        // 6. commit
        transaction.commit();
    }

    // Detail Fragment에서 List Fragment로 돌아갈 때
    public void backToList() {
        // 스택을 빼내면 된다. - popBackStack()에 해당된다.
        super.onBackPressed();
//        // 3. Fragment를 실행하기 위한 Transaction(프로세스 처리 단위) 가져오기
//        FragmentTransaction transaction = manager.beginTransaction();
//        // 4. Detail Fragment를 스택에서 제거한다.
//        transaction.remove(detail);
//        // 5. commit
//        transaction.commit();
    }
}
