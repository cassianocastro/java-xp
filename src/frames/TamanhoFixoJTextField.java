package frames;

import javax.swing.text.*;

/**
 *
 */
public class TamanhoFixoJTextField extends PlainDocument
{

    private final int tamMax;

    public TamanhoFixoJTextField(int tamMax)
    {
        super();
        this.tamMax = tamMax;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr)
        throws BadLocationException
    {
        if ( str == null )
        {
            return;
        }

        if ( this.tamMax <= 0 )
        {
            super.insertString(offset, str, attr);
            return;
        }
        int tam = ( getLength() + str.length() );

        if ( tam <= this.tamMax )
        {
            super.insertString(offset, str, attr);
            return;
        }

        if ( getLength() == this.tamMax )
        {
            return;
        }
        String novaStr = str.substring(0, ( this.tamMax - getLength() ));
        super.insertString(offset, novaStr, attr);
    }
}
