package util;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.Task;

public class TableButtonRenderer extends DefaultTableCellRenderer {
    private String buttontype;
    
    public TableButtonRenderer(String buttontype) {
        this.buttontype = buttontype;
    }

    public String getButtontype() {
        return buttontype;
    }

    public void setButtontype(String buttontype) {
        this.buttontype = buttontype;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label;
        label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        label.setHorizontalAlignment(JLabel.CENTER);
        TaskTableModel tasktablemodel = (TaskTableModel)table.getModel();
        Task task = tasktablemodel.getTasks().get(row);
        
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/" + buttontype +".png")));
        
        return label;
    }
}
