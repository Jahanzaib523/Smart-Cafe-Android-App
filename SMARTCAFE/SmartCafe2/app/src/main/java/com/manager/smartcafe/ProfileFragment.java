package com.manager.smartcafe;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.manager.smartcafe.Utils.Constants;
import com.manager.smartcafe.database.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }

    private DatabaseReference currCustomerDbRef;
    private FirebaseUser currUser;

    private TextView tvName,tvEmail,tvPhoneNo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        getActivity().setTitle("Profile");

        tvName = rootView.findViewById(R.id.tv_name);
        tvEmail = rootView.findViewById(R.id.tv_email);
        tvPhoneNo= rootView.findViewById(R.id.tv_phoneNo);


        currUser = FirebaseAuth.getInstance().getCurrentUser();

        currCustomerDbRef = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_MANAGER_DATABASE_REFERENCE).child(currUser.getUid());

        currCustomerDbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                tvName.setText(user.getName());
                tvEmail.setText(user.getEmail());
                tvPhoneNo.setText(user.getPhoneNo());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





        return rootView;
    }

}
