package com.mogobiz.sample.handlers

import com.mogobiz.run.handlers.CouponHandler
import com.mogobiz.run.model.Mogobiz.{ReductionRule, ReductionRuleType}
import com.mogobiz.run.model.StoreCartItemWithPrice


class MyCouponHandler extends CouponHandler {
  override protected def applyReductionRule(rule: ReductionRule, cartItem: StoreCartItemWithPrice, quantity: Long, price: Long, totalPrice: Long, cartItems: List[StoreCartItemWithPrice]): Long = {
    rule.xtype match {
      case ReductionRuleType.CUSTOM if rule.discount.forall(_.startsWith("MyCustomRule")) && cartItems.size > 10 =>
        computeDiscount(Some("10%"), totalPrice)
      case _ => super.applyReductionRule(rule, cartItem, quantity, price, totalPrice, cartItems)
    }
  }
}