import java.awt.*;

public class GridBagGUI {
  private GridBagConstraints gbc;
  private GridBagLayout layout;
  private Container container;

  public GridBagGUI( Container container ) {
    this.container = container;

    layout = new GridBagLayout();
    container.setLayout( layout );

    reset();
  }

  /*
   * Tilføjer 'component', med de indstillede constraints
   */
  public void add( Component component ) {
    layout.setConstraints( component, gbc );
    container.add( component );
  }

  /*
   * Constraints methods
   */

  /*
   * Clear'er alle indstillinger
   */
  public void reset() {
    gbc = new GridBagConstraints();
  }

  /*
   * Sætter relativ størrelse
   */
  public void setSize( int width, int height ) {
    setWidth( width );
    setHeight( height );
  }

  public void setWidth( int width ) {
    gbc.gridwidth = width;
  }

  public void setHeight( int height ) {
    gbc.gridheight = height;
  }

  public void setPosition( int x, int y ) {
    setPositionX( x );
    setPositionY( y );
  }

  public void setPositionX( int x ) {
    gbc.gridx = x;
  }

  public void setPositionY( int y ) {
    gbc.gridy = y;
  }

  /*
   * Sætter fill-egenskab ud fra char parameter:
   * 
   * GridBagConstraints.HORIZONTAL: Horisontalt GridBagConstraints.VERTICAL :
   * Vertikalt GridBagConstraints.BOTH : Horisontalt og vertikalt
   * GridBagConstraints.NONE : Ingen af delene (default)
   */
  public void setFill( int con ) {
    gbc.fill = con;
  }

  /*
   * Sætter fill-egenskab ud fra char parameter:
   * 
   * 'H': Horisontalt 'V': Vertikalt 'B': Horisontalt og vertikalt 'N': Ingen af
   * delene (default)
   */
  public void setFill( char con ) {
    con = Character.toUpperCase( con );

    switch ( con ) {
      case 'H':
        setFill( GridBagConstraints.HORIZONTAL );
        break;

      case 'V':
        setFill( GridBagConstraints.VERTICAL );
        break;

      case 'B':
        setFill( GridBagConstraints.BOTH );
        break;

      case 'N':
        setFill( GridBagConstraints.NONE );
        break;

      default:
        System.out.println( "[GridBagGUI.fill( '" + con + "' )] Unknown GridBagConstraint mnemonic" );
        System.exit( 0 );
    }
  }

  /*
   * Sætter fill-egenskab ud fra char parameter:
   * 
   * "HORIZONTAL": Horisontalt "VERTICAL" : Vertikalt "BOTH" : Horisontalt og
   * vertikalt "NONE" : Ingen af delene (default)
   */
  public void setFill( String con ) {
    if ( con.length() == 1 )
      setFill( con.charAt( 0 ) );

    else {
      con = con.toUpperCase();

      if ( con.equalsIgnoreCase( "HORIZONTAL" ) )
        setFill( GridBagConstraints.HORIZONTAL );

      else if ( con.equalsIgnoreCase( "VERTICAL" ) )
        setFill( GridBagConstraints.VERTICAL );

      else if ( con.equalsIgnoreCase( "BOTH" ) )
        setFill( GridBagConstraints.BOTH );

      else if ( con.equalsIgnoreCase( "NONE" ) )
        setFill( GridBagConstraints.NONE );

      else {
        System.out.println( "[GridBagGUI.fill( '" + con + "' )] Unknown GridBagConstraint mnemonic" );
        System.exit( 0 );
      }
    }
  }

  /*
   * Sætter den forholdsmæssige fordeling af ledig plads i hver retning
   * ('weightX': vandret, 'weightY': lodret)
   */
  public void setWeight( double weightX, double weightY ) {
    setWeightX( weightX );
    setWeightY( weightY );
  }

  /*
   * Sætter den forholdsmæssige fordeling af ledig plads vandret
   */
  public void setWeightX( double weight ) {
    gbc.weightx = weight;
  }

  /*
   * Sætter den forholdsmæssige fordeling af ledig plads lodret
   */
  public void setWeightY( double weight ) {
    gbc.weighty = weight;
  }

  /*
   * Sætter extern padding, dvs. padding udenom det tildelte område. Med
   * parametrene slipper man for selv at skulle lave en instans af
   * Insets-klassen
   */
  public void setInsets( int top, int left, int botton, int right ) {
    setInsets( new Insets( top, left, botton, right ) );
  }

  /*
   * Sætter extern padding, dvs. padding udenom det tildelte område
   */
  public void setInsets( Insets insets ) {
    gbc.insets = insets;
  }

  /*
   * Sætter intern padding, dvs. indenfor det tildelte område
   */
  public void setIPad( int padx, int pady ) {
    setIPadX( padx );
    setIPadY( pady );
  }

  /*
   * Sætter intern padding i bredden
   */
  public void setIPadX( int padx ) {
    gbc.ipadx = padx;
  }

  /*
   * Sætter intern padding i højden
   */
  public void setIPadY( int pady ) {
    gbc.ipady = pady;
  }

  /*
   * Sætter den retning hvori 'component' placeres i det tildelte område.
   * Parameteren er en konstant fra GridBagConstraints-klassen. F.eks.:
   * GridBagConstraints.NORTH
   */
  public void setAnchor( int dir ) {
    gbc.anchor = dir;
  }

  /*
   * Sætter den retning hvori 'component' placeres i det tildelte område.
   * Parameteren er en tekststreng der svarer til kompas-retningen (evt.
   * forkortet)
   */
  public void setAnchor( String dir ) {
    dir = dir.toUpperCase();

    if ( dir.equalsIgnoreCase( "CENTER" ) || dir.equalsIgnoreCase( "C" ) )
      setAnchor( GridBagConstraints.CENTER );

    else if ( dir.equalsIgnoreCase( "NORTH" ) || dir.equalsIgnoreCase( "N" ) )
      setAnchor( GridBagConstraints.NORTH );

    else if ( dir.equalsIgnoreCase( "NORTHEAST" ) || dir.equalsIgnoreCase( "NE" ) )
      setAnchor( GridBagConstraints.NORTHEAST );

    else if ( dir.equalsIgnoreCase( "EAST" ) || dir.equalsIgnoreCase( "E" ) )
      setAnchor( GridBagConstraints.EAST );

    else if ( dir.equalsIgnoreCase( "SOUTHEAST" ) || dir.equalsIgnoreCase( "SE" ) )
      setAnchor( GridBagConstraints.SOUTHEAST );

    else if ( dir.equalsIgnoreCase( "SOUTH" ) || dir.equalsIgnoreCase( "S" ) )
      setAnchor( GridBagConstraints.SOUTH );

    else if ( dir.equalsIgnoreCase( "SOUTHWEST" ) || dir.equalsIgnoreCase( "SW" ) )
      setAnchor( GridBagConstraints.SOUTHWEST );

    else if ( dir.equalsIgnoreCase( "WEST" ) || dir.equalsIgnoreCase( "W" ) )
      setAnchor( GridBagConstraints.WEST );

    else if ( dir.equalsIgnoreCase( "NORTHWEST" ) || dir.equalsIgnoreCase( "NW" ) )
      setAnchor( GridBagConstraints.NORTHWEST );

    else {
      System.out.println( "[GridBagGUI.anchor( '" + dir + "' )] Unknown GridBagConstraint mnemonic" );
      System.exit( 0 );
    }
  }
}
