package com.gamma.airlines.customer.export.purchasingorder;

// package com.gamma.airlines.customer.purchasing.export;
//
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.context.annotation.Import;
// import org.springframework.security.test.context.support.WithMockUser;
// import org.springframework.test.context.junit4.SpringRunner;
// import org.springframework.test.web.servlet.MockMvc;
//
// import com.gamma.airlines.WebMvcConfig;
// import com.gamma.airlines.WebSecurityConfig;
// import com.gamma.airlines.properties.RolesProperties;
// import com.gamma.airlines.properties.URLS;
//
// @RunWith(SpringRunner.class)
// @WebMvcTest(ExportPurchasingOrderController.class)
// @Import({WebSecurityConfig.class, WebMvcConfig.class})
// public class ExportPurchasingOrderControllerTest {
//
// @Autowired
// private MockMvc mockMvc;
//
// @MockBean
// private ExportPurchasingOrderService exportPurchasingOrderService;
//
// private static final String FORMAT_ATT_NAME = "format";
// private static final String DATASOURCE_ATT_NAME = "datasource";
// private static final String PDF_EXPORT_FORMAT = "pdf";
// private static final String PDF_PURCHSING_ORDER_VIEW = "customer/purchsing_order_pdf";
//
// @Test
// @WithMockUser(roles = RolesProperties.CUSTOMER)
// public void export_purchasing_order() throws Exception {
// final String inputOrderId = "1000";
//
// mockMvc.perform(get(URLS.CUSTOMER_EXPORT_PURCHASING_ORDER_PDF, inputOrderId))
// .andExpect(status().isOk()).andExpect(view().name(PDF_PURCHSING_ORDER_VIEW))
// .andExpect(model().attribute(FORMAT_ATT_NAME, PDF_EXPORT_FORMAT))
// .andExpect(model().attributeExists(DATASOURCE_ATT_NAME));
// }
//
// }
