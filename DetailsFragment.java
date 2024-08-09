package com.example.myfragment;

import static com.example.myfragment.ListDataSource.countPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Map;

public class DetailsFragment extends Fragment {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details_fragment,container,false);
        Bundle bundle;
        bundle = getArguments();


        String selectedName = bundle.getString("name");
        Map<String,String> item =ListDataSource.getInfoByName(selectedName);
        String name = item.get("name");
        String alias = item.get("alias");
        String info = item.get("info");
        String num = item.get("img");
        TextView txtName = view.findViewById(R.id.textView);
        TextView txtInfo = view.findViewById(R.id.textView2);
        txtName.setText(String.format("%s(%s)",name,alias));
        txtInfo.setText(info);
        ImageView image = view.findViewById(R.id.imageView);
        image.setImageResource(Integer.parseInt(num));

        TextView count = view.findViewById(R.id.count);
        Button btnP = view.findViewById(R.id.btnP);
        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String countText = count.getText().toString();
                int countNum = Integer.parseInt(countText);
                countNum++;
                count.setText(String.valueOf(countNum));
            }
        });
        Button btnM = view.findViewById(R.id.btnM);
        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String countText = count.getText().toString();
                int countNum = Integer.parseInt(countText);
                if (countNum>0){
                    countNum--;
                    count.setText(String.valueOf(countNum));
                }
            }
        });
        Button btnO = view.findViewById(R.id.btnO);
        btnO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countPage.put(item.get("name"),count.getText().toString());
                Toast.makeText(requireContext(), String.format("%sを%s個に変更", item.get("name"), count.getText().toString())
                        , Toast.LENGTH_SHORT).show();

            }
        });
        Button btnE = view.findViewById(R.id.btnE);
        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent i = new Intent(view.getContext(), CountPage.class);
            startActivity(i);
            }
        });
        return view;
    }
}
