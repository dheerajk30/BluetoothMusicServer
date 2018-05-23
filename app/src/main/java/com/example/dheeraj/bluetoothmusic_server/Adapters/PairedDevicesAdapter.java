package com.example.dheeraj.bluetoothmusic_server.Adapters;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dheeraj.bluetoothmusic_server.R;
import com.example.dheeraj.bluetoothmusic_server.mainmenu;

import java.util.Set;

/**
 * Created by dheeraj on 16/5/18.
 */


public class PairedDevicesAdapter extends RecyclerView.Adapter<PairedDevicesAdapter.viewholder> {

    Set<BluetoothDevice> data;
    Context ctx;

    public PairedDevicesAdapter(Context ctx, Set<BluetoothDevice> data) {
         this.data=data;
         this.ctx=ctx;
        Log.d("mainmenu", "constructor: "+this.data.size());

    }

    @Override
    public viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(ctx).inflate(R.layout.devicelayout,parent,false);
        Log.d("mainmenu", "onCreate: "+data.size());
        return new viewholder(v);
    }

    @Override
    public void onBindViewHolder(viewholder holder, int position) {
        holder.tvname.setText((data.toArray(new BluetoothDevice[0]))[position].getName());

        Log.d("mainmenu", "onBind: attahicng"+ (data.toArray(new BluetoothDevice[0]))[position].getName());
    }

    @Override
    public int getItemCount() {

        Log.d("mainmenu", "getItemCount: "+data.size());
        return data.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        public TextView tvname;

        public viewholder(View itemView) {
            super(itemView);
            Log.d("mainmenu", "viewholder: "+data.size());


            tvname=(TextView) itemView.findViewById(R.id.tvname);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    ((mainmenu)((Activity) ctx)).currDevice=data.toArray(new BluetoothDevice[0])[getAdapterPosition()];

                }
            });
        }
    }
}
