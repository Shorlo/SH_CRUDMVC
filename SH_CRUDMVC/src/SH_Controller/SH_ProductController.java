package SH_Controller;

import SH_Model.SH_Product;
import SH_Model.SH_QueryProduct;
import SH_VIew.SH_ViewProduct;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Shorlo
 */
public class SH_ProductController implements ActionListener
{
    private SH_Product product;
    private SH_QueryProduct query;
    private SH_ViewProduct view;
    
    /**
     * Constructor
     */
    
    public SH_ProductController(SH_Product product, SH_QueryProduct  query, SH_ViewProduct view)
    {
        this.product = product;
        this.query = query;
        this.view = view;
        this.view.btnSave.addActionListener(this);
        this.view.btnModify.addActionListener(this);
        this.view.btnDelete.addActionListener(this);
        this.view.btnClean.addActionListener(this);
        this.view.btnSearch.addActionListener(this);
    }
    
    
    public void start()
    {
        view.setTitle("Products"); // Title
        view.setLocationRelativeTo(null); // Center view
        view.txtId.setVisible(false); // Hire Id text
        
    }
    
    @Override
    public void actionPerformed(ActionEvent event)
    {
        /**
         * Save botton
         */
        
        if(event.getSource() == view.btnSave)
        {
            product.setCode(view.txtCode.getText());
            product.setName(view.txtName.getText());
            product.setPrice(Double.parseDouble(view.txtPrice.getText()));
            product.setQuantity(Integer.parseInt(view.txtQuantity.getText()));
            
            if (query.register(product))
            {
                JOptionPane.showMessageDialog(null, "Register saved!");
                clean();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error saving!!");
                clean();
            }
        }
        
        /**
         * Modify botton
         */
        
        if(event.getSource() == view.btnModify)
        {
            
            product.setId(Integer.parseInt(view.txtId.getText()));
            product.setCode(view.txtCode.getText());
            product.setName(view.txtName.getText());
            product.setPrice(Double.parseDouble(view.txtPrice.getText()));
            product.setQuantity(Integer.parseInt(view.txtQuantity.getText()));
            
            if (query.modify(product))
            {
                JOptionPane.showMessageDialog(null, "Register modified!");
                clean();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error modifying!!");
                clean();
            }
        }
        
        /**
         * Delete botton
         */
        
        if(event.getSource() == view.btnDelete)
        {
            
            product.setId(Integer.parseInt(view.txtId.getText()));
            
            if (query.delete(product))
            {
                JOptionPane.showMessageDialog(null, "Register deleted!");
                clean();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error deleting!!");
                clean();
            }
        }
        
        /**
         * Search botton
         */
        
        if(event.getSource() == view.btnSearch)
        {
            
            product.setCode(view.txtCode.getText());
            
            if (query.search(product))
            {
                
                view.txtId.setText(String.valueOf(product.getId()));
                view.txtCode.setText(product.getCode());
                view.txtName.setText(product.getName());
                view.txtPrice.setText(String.valueOf(product.getPrice()));
                view.txtQuantity.setText(String.valueOf(product.getQuantity()));
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Register not found!!");
                clean();
            }
        }
        
        /**
         * Clean botton
         */
        
        if (event.getSource() == view.btnClean)
        {
            clean();
        }
    }
    
    public void clean()
    {
        view.txtId.setText(null);
        view.txtCode.setText(null);
        view.txtName.setText(null);
        view.txtPrice.setText(null);
        view.txtQuantity.setText(null);
    }
}
