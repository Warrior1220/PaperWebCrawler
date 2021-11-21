package gui.view;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import bean.result.BaseResult;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.HashMap;

/**
 * @author yagol
 * @TIME 2021/11/15 - 1:50 下午
 * @Description
 **/
public class PaperInfoGui implements BaseGui {
    private final Log log = LogFactory.get();
    private JPanel paperInfo;
    private JTable paperInfoTable;
    private JLabel searchInputLabel;
    private JLabel searchLabel;
    private JScrollPane jScrollPane;
    private JPanel upperPanel;
    private JButton showChartButton;
    private JFrame frame;

    @Override
    public void start(HashMap<String, Object> data) {
        DefaultTableModel tableModel = (DefaultTableModel) paperInfoTable.getModel();
        if (data.containsKey(BaseResult.class.getSimpleName())) {
            if (data.get(BaseResult.class.getSimpleName()) instanceof BaseResult) {
                BaseResult result = (BaseResult) data.get(BaseResult.class.getSimpleName());
                tableModel.setColumnIdentifiers(result.genHeader());
                result.genResults().forEach(tableModel::addRow);
                RowSorter<TableModel> rowSorter = new TableRowSorter<>(tableModel);
                paperInfoTable.setRowSorter(rowSorter);
                paperInfoTable.setModel(tableModel);
                searchInputLabel.setText(result.getSearchQuery());
            }
        } else {
            log.info("文献表格初始化错误");
        }

    }

    @Override
    public PaperInfoGui init() {
        frame = new JFrame("PaperInfoGui");
        frame.setContentPane(paperInfo);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(false);
        return this;
    }

    @Override
    public void show() {
        frame.setVisible(true);
    }

    @Override
    public void initComponentFunctions() {

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PaperInfoGui");
        frame.setContentPane(new PaperInfoGui().paperInfo);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        paperInfoTable = new JTable();
        paperInfoTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        paperInfo = new JPanel();
        paperInfo.setLayout(new GridBagLayout());
        paperInfo.setPreferredSize(new Dimension(900, 800));
        paperInfo.setVisible(true);
        upperPanel = new JPanel();
        upperPanel.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        paperInfo.add(upperPanel, gbc);
        searchLabel = new JLabel();
        searchLabel.setText("查询的关键字是：");
        upperPanel.add(searchLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        searchInputLabel = new JLabel();
        searchInputLabel.setText("Label");
        upperPanel.add(searchInputLabel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jScrollPane = new JScrollPane();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        paperInfo.add(jScrollPane, gbc);
        jScrollPane.setViewportView(paperInfoTable);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        paperInfo.add(spacer1, gbc);
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        paperInfo.add(panel1, gbc);
        showChartButton = new JButton();
        showChartButton.setText("折线图");
        panel1.add(showChartButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        panel1.add(spacer2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return paperInfo;
    }

}
