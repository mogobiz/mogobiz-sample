package com.mogobiz.samplej7.config;

import com.mogobiz.pay.handlers.shipping.EasyPostHandler;
import com.mogobiz.run.config.DefaultMogobizCake;
import com.mogobiz.run.handlers.CouponHandler;
import com.mogobiz.samplej7.handlers.MyCouponHandler;

public class SampleCake extends DefaultMogobizCake {
  @Override
  public EasyPostHandler easyPostHandler() {
    return null;
  }

  @Override
  public CouponHandler couponHandler() {
    return new MyCouponHandler();
  }

}
