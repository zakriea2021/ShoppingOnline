package com.calc.fragrancecart;


import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.LayerDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.calc.fragrancecart.count.Utils;
import com.calc.fragrancecart.data.FragranceContract;
import com.calc.fragrancecart.data.FragranceDbHelper;

import static com.calc.fragrancecart.data.FragranceContract.FragranceEntry.CART_TABLE;

//import android.support.v4.view.MenuItemCompat;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.GridLayoutManager;
//import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private RecyclerView recyclerView;
    FragranceAdapter fragranceAdapter;
    private static final int FRAGRANCE_LOADER = 0;
    FragranceDbHelper fragranceDbHelper;
    private SQLiteDatabase mDb;
    Button button;

    private int mNotificationsCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragranceDbHelper dbHelper = new FragranceDbHelper(this);
        mDb = dbHelper.getWritableDatabase();

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CartActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        }

        fragranceAdapter = new FragranceAdapter(this, null);
        recyclerView.setAdapter(fragranceAdapter);

        getLoaderManager().initLoader(FRAGRANCE_LOADER,null,this);

        new FetchCountTask().execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        // Get the notifications MenuItem and
        // its LayerDrawable (layer-list)
        MenuItem item = menu.findItem(R.id.action_notifications);
        LayerDrawable icon = (LayerDrawable) item.getIcon();

        // Update LayerDrawable's BadgeDrawable
        Utils.setBadgeCount(this, icon, mNotificationsCount);

        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_notifications: {
                Intent intent = new Intent(this, CartActivity.class);
                startActivity(intent);
                return true;
            }
            case R.id.action_settings: {
                Intent intent = new Intent(this, MainActivity2.class);
                startActivity(intent);
                return true;
            }

            case R.id.action_payments: {
                Intent intent = new Intent(this, NotificationsActivity.class);
                startActivity(intent);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateNotificationsBadge(int count) {
        mNotificationsCount = count;

        // force the ActionBar to relayout its MenuItems.
        // onCreateOptionsMenu(Menu) will be called again.
        invalidateOptionsMenu();
    }
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        // Define a projection that specifies the columns from the table we care about.
        String[] projection = {
                FragranceContract.FragranceEntry._ID,
                FragranceContract.FragranceEntry.COLUMN_NAME,
                FragranceContract.FragranceEntry.COLUMN_DESCRIPTION,
                FragranceContract.FragranceEntry.COLUMN_IMAGE,
                FragranceContract.FragranceEntry.COLUMN_PRICE,
                FragranceContract.FragranceEntry.COLUMN_USERRATING
        };

        // This loader will execute the ContentProvider's query method on a background thread
        return new CursorLoader(this,   // Parent activity context
                FragranceContract.FragranceEntry.CONTENT_URI,   // Provider content URI to query
                projection,             // Columns to include in the resulting Cursor
                null,                   // No selection clause
                null,                   // No selection arguments
                null);                  // Default sort order
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

        fragranceAdapter.swapCursor(data);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

        fragranceAdapter.swapCursor(null);

    }

    /*
  AsyncTask to fetch the notifications count
  */
    class FetchCountTask extends AsyncTask<Void, Void, Integer> {

        @Override
        protected Integer doInBackground(Void... params) {
            String countQuery = "SELECT  * FROM " + CART_TABLE;
            Cursor cursor = mDb.rawQuery(countQuery, null);
            int count = cursor.getCount();
            cursor.close();
            return count;
        }

        @Override
        public void onPostExecute(Integer count) {
            updateNotificationsBadge(count);
        }
    }
}
