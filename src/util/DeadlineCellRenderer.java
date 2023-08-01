package util;

import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.Task;

public class DeadlineCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label;
        label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        label.setHorizontalAlignment(JLabel.CENTER);
        TaskTableModel tasktablemodel = (TaskTableModel)table.getModel();
        Task task = tasktablemodel.getTasks().get(row);
        
        if(task.getDeadline().after(new Date())) {
            label.setBackground(new Color(20, 200, 40));
        } else {
            label.setBackground(new Color(255, 40, 30));
        }
        
        return label;
    }
}
