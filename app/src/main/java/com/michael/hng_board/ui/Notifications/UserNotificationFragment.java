package com.michael.hng_board.ui.Notifications;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.michael.hng_board.Adapters.NotificationAdapter;
import com.michael.hng_board.R;
import com.michael.hng_board.Utils.Helper;

public class UserNotificationFragment extends Fragment {

    private UserNotificationViewModel mViewModel;
    private RecyclerView recyclerView;
    private Helper helper;
    NotificationAdapter notificationAdapter;

    public static UserNotificationFragment newInstance() {
        return new UserNotificationFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.user_notification_fragment, container, false);
        helper = new Helper();

        recyclerView = root.findViewById(R.id.notification_recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        notificationAdapter = new NotificationAdapter(getContext(), helper.notificationLocalData());
        recyclerView.setAdapter(notificationAdapter);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(UserNotificationViewModel.class);
        // TODO: Use the ViewModel
    }

}