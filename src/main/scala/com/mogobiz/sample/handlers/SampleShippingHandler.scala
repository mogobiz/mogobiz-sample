package com.mogobiz.sample.handlers

import java.util.UUID

import com.mogobiz.pay.common.Cart
import com.mogobiz.pay.handlers.shipping.ShippingHandler
import com.mogobiz.pay.model.Mogopay.{ ShippingAddress, ShippingData }

class SampleShippingHandler extends ShippingHandler {
  val SAMPLE_SHIPPING_PREFIX = "SAMPLE_SHIPPING_"
  val SAMPLE_SHIPPING_AMOUNT = 500 // in the smallest currency unit (for USD & EURO this amount is in cents)

  override def computePrice(shippingAddress: ShippingAddress, cart: Cart): Seq[ShippingData] =
    Seq(ShippingData(shippingAddress.address, SAMPLE_SHIPPING_PREFIX + UUID.randomUUID().toString, UUID.randomUUID().toString, "SAMPLE", "SAMPLE", "SAMPLE", SAMPLE_SHIPPING_AMOUNT, "EUR", 2))

  override def isValidShipmentId(shippingPrice: ShippingData): Boolean = shippingPrice.shipmentId.startsWith(SAMPLE_SHIPPING_PREFIX)

  override def confirmShipmentId(shippingPrice: ShippingData): ShippingData = shippingPrice.copy(confirm = true)

}
