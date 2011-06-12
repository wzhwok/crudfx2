package testapplication.pages;

import crudfx2.core.gui.control.*;
import crudfx2.core.gui.container.*;
import crudfx2.core.gui.layout.*;
import crudfxicons.*;

public class Icons16 {
    static TabPage page=null;
    public static TabPage get(){
	if(page==null){
	    page=new TabPage()
		.title("16 x 16")
                .body(new SuiteCrowd()           
                    .item(new StandardLabel().title("i16_calendar  ").icon(CRUDfxIcons.i16_calendar))
                    .item(new StandardLabel().title("i16_computer  ").icon(CRUDfxIcons.i16_computer))
                    .item(new StandardLabel().title("i16_copy  ").icon(CRUDfxIcons.i16_copy))
                    .item(new StandardLabel().title("i16_cut  ").icon(CRUDfxIcons.i16_cut))
                    .item(new StandardLabel().title("i16_database  ").icon(CRUDfxIcons.i16_database))
                    .item(new StandardLabel().title("i16_decrypt  ").icon(CRUDfxIcons.i16_decrypt))
                    .item(new StandardLabel().title("i16_delete  ").icon(CRUDfxIcons.i16_delete))
                    .item(new StandardLabel().title("i16_down  ").icon(CRUDfxIcons.i16_down))
                    .item(new StandardLabel().title("i16_edit  ").icon(CRUDfxIcons.i16_edit))
                    .item(new StandardLabel().title("i16_favorites  ").icon(CRUDfxIcons.i16_favorites))
                    .item(new StandardLabel().title("i16_folder  ").icon(CRUDfxIcons.i16_folder))
                    .item(new StandardLabel().title("i16_folder_documents  ").icon(CRUDfxIcons.i16_folder_documents))
                    .item(new StandardLabel().title("i16_internet  ").icon(CRUDfxIcons.i16_internet))
                    .item(new StandardLabel().title("i16_message  ").icon(CRUDfxIcons.i16_message))
                    .item(new StandardLabel().title("i16_next  ").icon(CRUDfxIcons.i16_next))
                    .item(new StandardLabel().title("i16_ok_apply  ").icon(CRUDfxIcons.i16_ok_apply))
                    .item(new StandardLabel().title("i16_optical_data  ").icon(CRUDfxIcons.i16_optical_data))
                    .item(new StandardLabel().title("i16_password  ").icon(CRUDfxIcons.i16_password))
                    .item(new StandardLabel().title("i16_paste  ").icon(CRUDfxIcons.i16_paste))
                    .item(new StandardLabel().title("i16_phone  ").icon(CRUDfxIcons.i16_phone))
                    .item(new StandardLabel().title("i16_previous  ").icon(CRUDfxIcons.i16_previous))
                    .item(new StandardLabel().title("i16_printer  ").icon(CRUDfxIcons.i16_printer))
                    .item(new StandardLabel().title("i16_quickopen  ").icon(CRUDfxIcons.i16_quickopen))
                    .item(new StandardLabel().title("i16_receive  ").icon(CRUDfxIcons.i16_receive))
                    .item(new StandardLabel().title("i16_redo  ").icon(CRUDfxIcons.i16_redo))
                    .item(new StandardLabel().title("i16_refresh  ").icon(CRUDfxIcons.i16_refresh))
                    .item(new StandardLabel().title("i16_select_all  ").icon(CRUDfxIcons.i16_select_all))
                    .item(new StandardLabel().title("i16_statistics  ").icon(CRUDfxIcons.i16_statistics))
                    .item(new StandardLabel().title("i16_system  ").icon(CRUDfxIcons.i16_system))
                    .item(new StandardLabel().title("i16_undo  ").icon(CRUDfxIcons.i16_undo))
                    .item(new StandardLabel().title("i16_up  ").icon(CRUDfxIcons.i16_up))
                    .item(new StandardLabel().title("i16_user_away  ").icon(CRUDfxIcons.i16_user_away))
                    .item(new StandardLabel().title("i16_user_invisible  ").icon(CRUDfxIcons.i16_user_invisible))
                    .item(new StandardLabel().title("i16_user_online  ").icon(CRUDfxIcons.i16_user_online))
                    .item(new StandardLabel().title("i16_users  ").icon(CRUDfxIcons.i16_users))
                    .item(new StandardLabel().title("i16_warning  ").icon(CRUDfxIcons.i16_warning))
                    .item(new StandardLabel().title("i16_wireless  ").icon(CRUDfxIcons.i16_wireless))
                    .item(new StandardLabel().title("i16_zoom  ").icon(CRUDfxIcons.i16_zoom))
                    )
		;
	    }
	return page;
	}
}
