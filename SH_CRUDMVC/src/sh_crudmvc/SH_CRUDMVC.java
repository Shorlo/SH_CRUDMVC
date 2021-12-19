package sh_crudmvc;

import SH_Controller.SH_ProductController;
import SH_Model.SH_Product;
import SH_Model.SH_QueryProduct;
import SH_VIew.SH_ViewProduct;

/**
 *
 * @author Shorlo
 */
public class SH_CRUDMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        
        SH_Product product = new SH_Product();
        SH_QueryProduct query = new SH_QueryProduct();
        SH_ViewProduct view = new SH_ViewProduct();
        
        SH_ProductController controller = new SH_ProductController(product, query, view);
        
        controller.start();
        view.setVisible(true);
        
    }
    
}
