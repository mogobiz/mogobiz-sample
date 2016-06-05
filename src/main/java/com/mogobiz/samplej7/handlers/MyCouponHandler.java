package com.mogobiz.samplej7.handlers;

import com.mogobiz.run.handlers.CouponHandler;
import com.mogobiz.run.model.Mogobiz.ReductionRuleType;
import com.mogobiz.run.model.Mogobiz.ReductionRule;
import com.mogobiz.run.model.StoreCartItemWithPrice;
import scala.Function1;
import scala.Some;
import scala.collection.immutable.List;

public class MyCouponHandler extends CouponHandler {
  @Override
  public long applyReductionRule(ReductionRule rule, StoreCartItemWithPrice cartItem, long quantity, long price, long totalPrice, List<StoreCartItemWithPrice> cartItems) {
    if (rule.xtype().equals(ReductionRuleType.CUSTOM()) &&
        rule.discount().forall(new Function1<String, Object>() {
          @Override
          public Object apply(String v) {
            return v.startsWith("MyCustomRule");
          }
        }) &&
        cartItems.size() > 10) {
      return computeDiscount(Some.apply("10%"), totalPrice);
    } else {
      return super.applyReductionRule(rule, cartItem, quantity, price, totalPrice, cartItems);
    }
  }
}
