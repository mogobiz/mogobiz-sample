package com.mogobiz.samplej7.handlers;

import com.mogobiz.pay.common.Cart;
import com.mogobiz.pay.handlers.shipping.ShippingHandler;
import com.mogobiz.pay.model.Mogopay;
import com.typesafe.scalalogging.Logger;
import scala.collection.Seq;

import java.util.UUID;

/**
 * Created by hayssams on 03/06/16.
 */
public class SampleShippingHandler extends ShippingHandler {
  final String SAMPLE_SHIPPING_PREFIX = "SAMPLE_SHIPPING_"
  final int SAMPLE_SHIPPING_AMOUNT = 500 // in the smallest currency unit (for USD & EURO this amount is in cents)

  @Override
  public Seq<Mogopay.ShippingData> computePrice(Mogopay.ShippingAddress shippingAddress, Cart cart) {
    return new Seq(new Mogopay.ShippingData(shippingAddress.address(), SAMPLE_SHIPPING_PREFIX + UUID.randomUUID().toString(), UUID.randomUUID().toString(), "SAMPLE", "SAMPLE", "SAMPLE", SAMPLE_SHIPPING_AMOUNT, "EUR", 2))
  }

  @Override
  public boolean isValidShipmentId(Mogopay.ShippingData shippingPrice) {
    return false;
  }

  @Override
  public Mogopay.ShippingData confirmShipmentId(Mogopay.ShippingData shippingPrice) {
    return null;
  }

  @Override
  public Logger logger() {
    return null;
  }
}
