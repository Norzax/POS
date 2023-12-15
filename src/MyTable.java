import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyTable extends JFrame{

  //MAIN METHOD
  public static void main(String[] args)
  {

       EventQueue.invokeLater(new Runnable()
       {
           public void run()
           {
               //INITIALIZE JFRAME FORM
               MyTable form=new MyTable();
               form.setVisible(true);;
           }
       });

  }

  //CONSTRUCTOR
  public MyTable()
  {
    //the form
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(200,200,800,300);
    setTitle("ProgrammingWizards Channel");
    getContentPane().setLayout(null);

    //ADD SCROLLPANE
    JScrollPane scroll=new JScrollPane();
    scroll.setBounds(70,80,600,200);
    getContentPane().add(scroll);

    //THE TABLE
    final JTable table=new JTable();
    scroll.setViewportView(table);

    //THE MODEL OF OUR TABLE
    DefaultTableModel model=new DefaultTableModel()
    {
      public Class<?> getColumnClass(int column)
      {
        switch(column)
        {
        case 0:
          return Boolean.class;
        case 1:
          return String.class;
        case 2:
          return String.class;
        case 3:
          return String.class;
        case 4:
          return String.class;

          default:
            return String.class;
        }
      }
    };

    //ASSIGN THE MODEL TO TABLE
    table.setModel(model);

    model.addColumn("Select");
    model.addColumn("Position");
    model.addColumn("Team");
    model.addColumn("Points");
    model.addColumn("Manager");

    //THE ROW
    for(int i=0;i<=7;i++)
    {
      model.addRow(new Object[0]);
      model.setValueAt(false,i,0);
      model.setValueAt("Our Row"+(i+1), i, 1);
      model.setValueAt("Our Column 2", i, 2);
      model.setValueAt("Our Column 3", i, 3);
      model.setValueAt("Our Column 4", i, 4);
    }

    //OBTAIN SELECTED ROW
    JButton btn=new JButton("Get Selected");
    btn.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub

        //GET SELECTED ROW
        for(int i=0;i<table.getRowCount();i++)
        {
          Boolean checked=Boolean.valueOf(table.getValueAt(i, 0).toString());
          String col=table.getValueAt(i, 1).toString();

          //DISPLAY
          if(checked)
          {
            JOptionPane.showMessageDialog(null, col);
          }
        }

      }
    });

    //ADD BUTTON TO FORM
    btn.setBounds(20,30,130,30);
    getContentPane().add(btn);
  }

}