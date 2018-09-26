package com.jewellery.jewellery_list_detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jewellery.R;
import com.jewellery.data.local.AppDatabase;
import com.jewellery.data.local.entity.Cateloguecategory;
import com.jewellery.data.local.entity.Jewellery;
import com.jewellery.data.local.utils.DatabaseInitializer;
import com.jewellery.rest.ApiClient;
import com.jewellery.rest.ApiInterface;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JewelleryActivity extends AppCompatActivity {

  static String TAG = JewelleryActivity.class.getSimpleName();
  @BindView(R.id.recycler_view)
  RecyclerView mRecyclerView;
  @BindView(R.id.progressbar)
  ProgressBar mProgressbar;
  List<Cateloguecategory> mJewelleryList = new ArrayList<Cateloguecategory>();
  boolean firstTimeLoad = true;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_jewellery);
    ButterKnife.bind(this);
    renderView();
    getJewelleryList();
  }


  /**
   * fetch Jewellery list available in local database first if not fetch from network
   */
  private void getJewelleryList() {

    /*if (firstTimeLoad){//for updated data
      getJewelleryListNetwork();
      firstTimeLoad=false;
      return;
    }*/

    if (!getJewelleryListLocal()) {
      //fetch from netwrok
      getJewelleryListNetwork();
    }
  }


  /**
   * fetch Jewellery category list from database
   */
  private boolean getJewelleryListLocal() {
    try {
      showProgressbar(true);
      List<Cateloguecategory> jewelleryCatList = DatabaseInitializer
          .getAllJewelleryList(AppDatabase.getAppDatabase(this));

      if (jewelleryCatList != null && jewelleryCatList.size() > 0) {
        setAdapter(jewelleryCatList);
        return true;
      } else {
        return false;
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      showProgressbar(false);
    }
    return false;
  }


  /**
   * render view
   */
  private void renderView() {
    if (mRecyclerView != null) {
      mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    setAdapter(mJewelleryList);
  }


  /**
   * handle sucess response load data in adapter and save into database
   */
  private void handleResponse(Response<Jewellery> response) {
    mJewelleryList = response.body().getCateloguecategory();
    setAdapter(mJewelleryList);
    saveToLocalDataBase(mJewelleryList);
    Log.d(TAG, "Number of jewellery received: " + mJewelleryList.size());

  }


  /**
   * save jewellry list to datbase
   */
  private void saveToLocalDataBase(
      List<Cateloguecategory> jewelleryCatList) {
    DatabaseInitializer.populateAsync(AppDatabase.getAppDatabase(this),
        jewelleryCatList);

  }


  /**
   * set dataset to recyclview adapter
   */
  private void setAdapter(List<Cateloguecategory> jewelleryList) {
    if (jewelleryList != null) {
      mRecyclerView.setAdapter(new JewelleryListAdapter(jewelleryList));
    }

  }


  /**
   * hide and show progresbar
   */
  private void showProgressbar(boolean show) {
    if (mProgressbar != null) {
      if (show) {
        mProgressbar.setVisibility(View.VISIBLE);
      } else {
        mProgressbar.setVisibility(View.GONE);
      }

    }
  }


  /**
   * request new jewellery list from network
   */
  private void getJewelleryListNetwork() {
    //if (NetworkUitils.isNetworkAvailable(this)) {
    showProgressbar(true);
    ApiInterface apiService =
        ApiClient.getClient().create(ApiInterface.class);

    Call<Jewellery> call = apiService.getJewelleryList();
    call.enqueue(new Callback<Jewellery>() {
      @Override
      public void onResponse(Call<Jewellery> call, Response<Jewellery> response) {
        showProgressbar(false);
        handleResponse(response);
      }

      @Override
      public void onFailure(Call<Jewellery> call, Throwable t) {
        showProgressbar(false);
        // Log error here since request failed
        Log.e(TAG, t.toString());
      }
    });

    /*}else {
      Toast.makeText(this, getString(R.string.network_conn_err_msg), Toast.LENGTH_SHORT).show();
    }*/

  }

}
