package per.jianfei.studyfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentActivity fragmentActivity;

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        Log.d("debug", "碎片创建");
        fragmentActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("debug", "创建视图");
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        TextView textView = view.findViewById(R.id.fragment_blank_text_view);
        textView.setOnClickListener(this);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("debug", "碎片开始");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("debug", "碎片中断之后重新开始");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("debug", "碎片暂停");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("debug", "碎片停止");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("debug", "销毁视图");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("debug", "碎片销毁");
    }

    @Override
    public void onClick(View v) {
        androidx.fragment.app.FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.activity_main_frame_layout, ItemFragment.newInstance(30), ItemFragment.class.getSimpleName());
        fragmentTransaction.addToBackStack(ItemFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }
}