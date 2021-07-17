package architectural.api_gateway;

/**
 * Intent
 * Aggregate calls to microservices in a single location, the API Gateway.
 * The user makes a single call to the API Gateway, and the API Gateway then calls each relevant microservice.
 *
 * Applicability
 * Use the API Gateway pattern when
 *
 * You're using microservices architecture and need a single point of aggregation for your microservice calls.
 */
public class ApiGateway {
    @Resource
    private ImageClient imageClient;

    @Resource
    private PriceClient priceClient;

    @RequestMapping(path = "/desktop", method = "RequestMethod.GET")
    public DesktopProduct getProductDesktop() {
        DesktopProduct desktopProduct = new DesktopProduct();
        desktopProduct.setImagePath(imageClient.getImagePath());
        desktopProduct.setPrice(priceClient.getPrice());
        return desktopProduct;
    }

    @RequestMapping(path = "/mobile", method = "RequestMethod.GET")
    public MobileProduct getProductMobile() {
        MobileProduct mobileProduct = new MobileProduct();
        mobileProduct.setPrice(priceClient.getPrice());
        return mobileProduct;
    }
}
