package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1=
            {
                    {"Doctor Name:Ajit Saste","Hospital Address:Pimpri","Exp:5yrs","Mobile No.:9938836221","600"},
                    {"Doctor Name:Prasad Pawar","Hospital Address:Nigdi","Exp:14yrs","Mobile No.:9762836221","900"},
                    {"Doctor Name:Swapnil Kale","Hospital Address:Pune","Exp:8yrs","Mobile No.:9932236221","300"},
                    {"Doctor Name:Deepak Deshmukh","Hospital Address:Chinchwad","Exp:6yrs","Mobile No.:9934536221","500"},
                    {"Doctor Name:Ashok Pande","Hospital Address:Katraj","Exp:15yrs","Mobile No.:9938887321","800"},

            };
    private String[][] doctor_details2=
            {
                    {"Doctor Name:Ruturaj Jadhav","Hospital Address:Pimpri","Exp:15yrs","Mobile No.:9938832781","1500"},
                    {"Doctor Name:Neera Mahajan","Hospital Address:Nigdi","Exp:4yrs","Mobile No.:9762827421","700"},
                    {"Doctor Name:Swanand Deshmane","Hospital Address:Pune","Exp:5yrs","Mobile No.:9871236221","600"},
                    {"Doctor Name:Kavya Limaye","Hospital Address:Chinchwad","Exp:2yrs","Mobile No.:9154536221","200"},
                    {"Doctor Name:Shekhar Mule","Hospital Address:Katraj","Exp:5yrs","Mobile No.:9928787321","700"},

            };
    private String[][] doctor_details3=
            {
                    {"Doctor Name:Omkar Shah","Hospital Address:Pimpri","Exp:9yrs","Mobile No.:9919236221","900"},
                    {"Doctor Name:Jaidev Lele","Hospital Address:Nigdi","Exp:14yrs","Mobile No.:9762267221","1200"},
                    {"Doctor Name:Maitri Shamraj","Hospital Address:Pune","Exp:3yrs","Mobile No.:9932678221","200"},
                    {"Doctor Name:Nakul Manjre","Hospital Address:Chinchwad","Exp:6yrs","Mobile No.:9934532561","500"},
                    {"Doctor Name:Ajit Bombale","Hospital Address:Katraj","Exp:15yrs","Mobile No.:9938817821","1800"},

            };
    private String[][] doctor_details4=
            {
                    {"Doctor Name:Kabir Saste","Hospital Address:Pimpri","Exp:7yrs","Mobile No.:9872836221","800"},
                    {"Doctor Name:Prasad Phule","Hospital Address:Nigdi","Exp:14yrs","Mobile No.:9763766221","900"},
                    {"Doctor Name:Swapnil Kolhe","Hospital Address:Pune","Exp:4yrs","Mobile No.:9892236221","300"},
                    {"Doctor Name:Nakshatra Deshmukh","Hospital Address:Chinchwad","Exp:2yrs","Mobile No.:9934536221","200"},
                    {"Doctor Name:Ashok Mane","Hospital Address:Katraj","Exp:17yrs","Mobile No.:9991287321","1200"},

            };
    private String[][] doctor_details5=
            {
                    {"Doctor Name:Nilesh Borate","Hospital Address:Pimpri","Exp:5yrs","Mobile No.:9938265221","500"},
                    {"Doctor Name:Pankaj Pawar","Hospital Address:Nigdi","Exp:4yrs","Mobile No.:9748236221","900"},
                    {"Doctor Name:Swapnaja Kale","Hospital Address:Pune","Exp:18yrs","Mobile No.:9937626221","700"},
                    {"Doctor Name:Deepak Deshmane","Hospital Address:Chinchwad","Exp:9yrs","Mobile No.:9934566221","200"},
                    {"Doctor Name:Sameer Pande","Hospital Address:Katraj","Exp:7yrs","Mobile No.:9234887321","1800"},

            };
    TextView tv;
    Button btn;

    String[][] doctor_details={};
    ArrayList list;
    SimpleAdapter sa;
    HashMap<String,String> item;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv=findViewById(R.id.textViewDDTitle);
        btn=findViewById(R.id.buttonBMCartBack);

        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details=doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details=doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details=doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details=doctor_details4;
        else
            doctor_details=doctor_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list=new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item=new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Consultant fees:"+doctor_details[i][4]+"/-");
            list.add(item);

        }
        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst=findViewById(R.id.listViewBMCart);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);

            }
        });
    }
}