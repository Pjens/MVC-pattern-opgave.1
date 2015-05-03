import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.*;

public class View extends JFrame implements ActionListener, Observer {
  private JButton opdaterButton;
  private JTextField indtastningsFelt;
  private JTextField usdFelt, gbpFelt, yenFelt, euroFelt;

  private Model model;

  public View( String title, Model model ) {
    super( title );

    this.model = model;
    
    model.addObserver( this );

    /*
     * Instantiering af widgets
     */
    usdFelt = new JTextField();
    usdFelt.setHorizontalAlignment( JTextField.RIGHT );
    usdFelt.setEditable( false );

    gbpFelt = new JTextField();
    gbpFelt.setHorizontalAlignment( JTextField.RIGHT );
    gbpFelt.setEditable( false );

    yenFelt = new JTextField();
    yenFelt.setHorizontalAlignment( JTextField.RIGHT );
    yenFelt.setEditable( false );

    euroFelt = new JTextField();
    euroFelt.setHorizontalAlignment( JTextField.RIGHT );
    euroFelt.setEditable( false );

    indtastningsFelt = new JTextField();

    opdaterButton = new JButton( "Opdater" );
    opdaterButton.addActionListener( this );

    /*
     * Layout
     */
    GridBagGUI gui = new GridBagGUI( getContentPane() );
    gui.setInsets( 5, 5, 5, 5 );
    gui.setSize( 1, 1 );

    // valuta labels
    gui.setAnchor( "West" );

    gui.setPosition( 0, 0 );
    gui.add( new JLabel( "USD $" ) );

    gui.setPosition( 0, 1 );
    gui.add( new JLabel( "GBP £" ) );

    gui.setPosition( 0, 2 );
    gui.add( new JLabel( "YEN" ) );

    gui.setPosition( 0, 3 );
    gui.add( new JLabel( "EURO" ) );

    // Valuta-felter
    gui.setAnchor( "Center" ); // for at slippe for reset af 'gui'
    gui.setFill( "Both" );
    gui.setWeightX( 1 );

    gui.setPosition( 1, 0 );
    gui.add( usdFelt );

    gui.setPosition( 1, 1 );
    gui.add( gbpFelt );

    gui.setPosition( 1, 2 );
    gui.add( yenFelt );

    gui.setPosition( 1, 3 );
    gui.add( euroFelt );

    // Indtastningsfelt
    gui.setPosition( 0, 4 );
    gui.setSize( 2, 1 );
    gui.add( indtastningsFelt );

    // Knap til at opdatere
    gui.setPosition( 0, 5 );
    gui.add( opdaterButton );

    setDefaultCloseOperation( EXIT_ON_CLOSE );

    setSize( 240, 230 );
    setVisible( true );
  }

  /*
   *  Eventhåndtering
   */
  @Override
  public void actionPerformed( ActionEvent event ) {
    try {
      double beløb = Double.parseDouble( indtastningsFelt.getText() );

      model.set( beløb );
    }
    catch ( NumberFormatException e ) {
      usdFelt.setText( "Error" );
      gbpFelt.setText( "Error" );
      yenFelt.setText( "Error" );
      euroFelt.setText( "Error" );
    }
  }

  /*
   *  Observer Pattern
   */
  @Override
  public void update( Observable obs, Object args ) {
    double beløb = ((Model) obs).get();

    DecimalFormat formater = new DecimalFormat( "#.##" );
    
    usdFelt.setText( formater.format( beløb / 7.3714 ) );
    gbpFelt.setText( formater.format( beløb / 11.7914 ) );
    yenFelt.setText( formater.format( beløb / 0.07212 ) );
    euroFelt.setText( formater.format( beløb / 7.4392 ) );
  }
}