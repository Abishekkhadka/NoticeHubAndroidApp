package com.example.noticehub_androidapp;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Find the change password TextView
        TextView tvChangePass = view.findViewById(R.id.tvChangePass);
        TextView tvChangeEmail = view.findViewById(R.id.tvChangeEmail);


        // Set click listener
        tvChangePass.setOnClickListener(v -> showChangePasswordDialog());
        tvChangeEmail.setOnClickListener(v -> showChangeEmailDialog());


        return view;
    }

    private void showChangeEmailDialog() {
        // Create a dialog builder
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Inflate the dialog layout
        View dialogView = LayoutInflater.from(getActivity()).inflate(R.layout.email_verify_dialog, null);

        // Set the view to the dialog
        builder.setView(dialogView);

        // Create and show the dialog
        AlertDialog dialog = builder.create();
        dialog.show();

        // Optional: Make dialog background transparent
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }

        // Handle back button click (if you have one in your dialog)
        TextView tvBackBtn = dialogView.findViewById(R.id.tvBackBtn);
        if (tvBackBtn != null) {
            tvBackBtn.setOnClickListener(v -> dialog.dismiss());
        }

    }

    private void showChangePasswordDialog() {
        // Create a dialog builder
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Inflate the dialog layout
        View dialogView = LayoutInflater.from(getActivity()).inflate(R.layout.change_password_dialog, null);

        // Set the view to the dialog
        builder.setView(dialogView);

        // Create and show the dialog
        AlertDialog dialog = builder.create();
        dialog.show();

        // Optional: Make dialog background transparent
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }

        // Handle back button click (if you have one in your dialog)
        TextView tvBackBtn = dialogView.findViewById(R.id.tvBackBtn);
        if (tvBackBtn != null) {
            tvBackBtn.setOnClickListener(v -> dialog.dismiss());
        }
    }
}