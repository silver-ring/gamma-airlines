/*
 * Cross Over trial project {@link www.crossover.com}
 */
package com.gamma.airlines.customer.export.purchasingorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gamma.airlines.common.IController;
import com.gamma.airlines.properties.RolesProperties;
import com.gamma.airlines.properties.URLS;


// TODO: Auto-generated Javadoc
/**
 * Class ExportPurchasingOrderController.
 *
 * @author Mohamed Morsy
 * @version 1.0
 */
@Controller
class ExportPurchasingOrderController implements IController {

  /** export purchasing order service. */
  @Autowired
  private ExportPurchasingOrderService exportPurchasingOrderService;


  /**
   * Export purchsing order.
   *
   * @param purchasingOrderEmailRequest purchasing order email request
   * @param model model
   * @return string
   */
  @Secured(RolesProperties.ROLE_CUSTOMER)
  @GetMapping(URLS.CUSTOMER_EXPORT_PURCHASING_ORDER_PDF)
  public String exportPurchsingOrder(ExportPurchasingOrderRequest purchasingOrderEmailRequest,
      Model model) {

    final String FORMAT_ATT_NAME = "format";
    final String DATASOURCE_ATT_NAME = "datasource";
    final String PDF_EXPORT_FORMAT = "pdf";
    final String PDF_PURCHSING_ORDER_VIEW = "customer/purchsing_order_pdf";

    PurchasingOrderPdfModel purchasingOrderPdf =
        exportPurchasingOrderService.findPurchasingOrder(purchasingOrderEmailRequest);

    PurchasingOrderPdfModel[] purchasingOrderPdfDataSource = {purchasingOrderPdf};

    model.addAttribute(DATASOURCE_ATT_NAME, purchasingOrderPdfDataSource);
    model.addAttribute(FORMAT_ATT_NAME, PDF_EXPORT_FORMAT);

    return PDF_PURCHSING_ORDER_VIEW;
  }

}
