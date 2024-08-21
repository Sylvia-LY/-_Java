import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class Data implements TableModel {

    private String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    private String[][] data = new String[8][5];

    public Data() {
        for ( int i=0; i<data.length; i++ ) {
            for ( int j=0; j< data[i].length; j++ ) {
                data[i][j] = "";
            }
        }
    }

    @Override
    public int getRowCount() {
        return 8;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return weekdays[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data[rowIndex][columnIndex] = (String)aValue;
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
