import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Calendar;
import java.util.Date;
import org.jdatepicker.impl.*;
import org.jdatepicker.util.*;
import org.jdatepicker.*;
public class date_trial
{
    date_trial()
    {
        JFrame frame1= new JFrame();
        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLocationRelativeTo(null);
        JPanel pan1= new JPanel();
        UtilDateModel model = new UtilDateModel();


        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);

        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel,new DateLabelFormatter());
        pan1.add(datePicker);
        frame1.add(pan1);
    }
    public static void main(String args[])
    {
        new date_trial();
    }
}
