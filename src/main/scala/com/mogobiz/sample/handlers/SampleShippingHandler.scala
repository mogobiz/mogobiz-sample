package com.mogobiz.sample.handlers

import java.util.UUID

import com.mogobiz.pay.common.Cart
import com.mogobiz.pay.handlers.shipping.{ ShippingHandler, ShippingPrice }
import com.mogobiz.pay.model.Mogopay.ShippingAddress

import scala.collection.Seq

class SampleShippingHandler extends ShippingHandler {
  val SAMPLE_SHIPPING_PREFIX = "SAMPLE_SHIPPING_"
  val SAMPLE_SHIPPING_AMOUNT = 500 // in the smallest currency unit (for USD & EURO this amount is in cents)

  override def computePrice(shippingAddress: ShippingAddress, cart: Cart): Seq[ShippingPrice] =
    Seq(ShippingPrice(SAMPLE_SHIPPING_PREFIX + UUID.randomUUID().toString, UUID.randomUUID().toString, "SAMPLE", "SAMPLE", "SAMPLE", SAMPLE_SHIPPING_AMOUNT, "EUR", 2))

  override def isValidShipmentId(shippingPrice: ShippingPrice): Boolean = shippingPrice.shipmentId.startsWith(SAMPLE_SHIPPING_PREFIX)

  override def confirmShipmentId(shippingPrice: ShippingPrice): ShippingPrice = shippingPrice.copy(confirm = true)

}
