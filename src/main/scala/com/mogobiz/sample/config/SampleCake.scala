package com.mogobiz.sample.config

import com.mogobiz.pay.handlers.shipping.EasyPostHandler
import com.mogobiz.run.config.DefaultMogobizCake
import com.mogobiz.sample.handlers.MyCouponHandler

class SampleCake extends DefaultMogobizCake {
  println("HOUHOU")
  println("HOUHOU")
  println("HOUHOU")
  println("HOUHOU")
  println("HOUHOU")
  println("HOUHOU")
  println("HOUHOU")
  println("HOUHOU")
  println("HOUHOU")
  override val easyPostHandler = new EasyPostHandler

  override val couponHandler = new MyCouponHandler

}

