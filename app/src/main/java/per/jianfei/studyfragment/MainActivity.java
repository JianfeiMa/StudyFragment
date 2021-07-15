package per.jianfei.studyfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int status = 0;
    private BlankFragment blankFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.activity_main_toolbar);
        setSupportActionBar(toolbar);
        blankFragment = BlankFragment.newInstance("param1", "param2");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.activity_main_frame_layout, blankFragment, BlankFragment.class.getSimpleName());
//        fragmentTransaction.addToBackStack(BlankFragment.class.getSimpleName());
        fragmentTransaction.commit();
        status = 0;
    }

    @Override
    protected void onStart() {
        super.onStart();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        androidx.fragment.app.FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (item.getItemId() == R.id.menu_main_item) {
            if (status == 0) {
                status = 1;
                Toast.makeText(this, "开始隐藏", Toast.LENGTH_SHORT).show();
                fragmentTransaction.hide(blankFragment);
                fragmentTransaction.commit();
            } else {
                status = 0;
                Toast.makeText(this, "开始显示", Toast.LENGTH_SHORT).show();
                fragmentTransaction.show(blankFragment);
                fragmentTransaction.commit();
            }
        } else if (item.getItemId() == R.id.menu_main_item1) {
            fragmentTransaction.add(ItemListDialogFragment.newInstance(5), ItemListDialogFragment.class.getSimpleName());
            fragmentTransaction.commit();
        } else if (item.getItemId() == R.id.menu_main_item2) {
            fragmentTransaction.add(new FullscreenFragment(), FullscreenFragment.class.getSimpleName());
            fragmentTransaction.commit();
        } else if (item.getItemId() == R.id.menu_main_item3) {
            fragmentTransaction.add(new ScrollingFragment(), ScrollingFragment.class.getSimpleName());
            fragmentTransaction.commit();
        } else if (item.getItemId() == R.id.menu_main_item4) {
            fragmentTransaction.add(new SettingsFragment(), SettingsFragment.class.getSimpleName());
            fragmentTransaction.commit();
        } else if (item.getItemId() == R.id.menu_main_item5) {
            List<Fragment> fragmentList = fragmentManager.getFragments();
            for (int i = 0; i < fragmentList.size(); i ++) {
                Fragment fragment = fragmentList.get(i);
                Log.d("debug", fragment.getClass().getSimpleName());
            }
        }
        return super.onOptionsItemSelected(item);
    }
}