package testapplication.pages;

import crudfx2.core.gui.control.*;
import crudfx2.core.gui.container.*;
import crudfx2.core.gui.layout.*;
import crudfxicons.*;

public class Icons128 {
    static TabPage page=null;
    public static TabPage get(){
	if(page==null){
	    page=new TabPage()
		.title("128 x 128")
		    .body(new SuiteCrowd()           
			.item(new StandardLabel().title("i128_calendar  ").icon(CRUDfxIcons.i128_calendar))
                        .item(new StandardLabel().title("i128_computer  ").icon(CRUDfxIcons.i128_computer))
                        .item(new StandardLabel().title("i128_copy  ").icon(CRUDfxIcons.i128_copy))
                        .item(new StandardLabel().title("i128_cut  ").icon(CRUDfxIcons.i128_cut))
                        .item(new StandardLabel().title("i128_database  ").icon(CRUDfxIcons.i128_database))
                        .item(new StandardLabel().title("i128_decrypt  ").icon(CRUDfxIcons.i128_decrypt))
                        .item(new StandardLabel().title("i128_delete  ").icon(CRUDfxIcons.i128_delete))
                        .item(new StandardLabel().title("i128_down  ").icon(CRUDfxIcons.i128_down))
                        .item(new StandardLabel().title("i128_edit  ").icon(CRUDfxIcons.i128_edit))
                        .item(new StandardLabel().title("i128_favorites  ").icon(CRUDfxIcons.i128_favorites))
                        .item(new StandardLabel().title("i128_folder  ").icon(CRUDfxIcons.i128_folder))
                        .item(new StandardLabel().title("i128_folder_documents  ").icon(CRUDfxIcons.i128_folder_documents))
                        //.item(new StandardLabel().title("i128_folder_open  ").icon(CRUDfxIcons.i128_folder_open))
                        .item(new StandardLabel().title("i128_internet  ").icon(CRUDfxIcons.i128_internet))
                        .item(new StandardLabel().title("i128_message  ").icon(CRUDfxIcons.i128_message))
                        .item(new StandardLabel().title("i128_next  ").icon(CRUDfxIcons.i128_next))
                        .item(new StandardLabel().title("i128_ok_apply  ").icon(CRUDfxIcons.i128_ok_apply))
                        .item(new StandardLabel().title("i128_optical_data  ").icon(CRUDfxIcons.i128_optical_data))
                        .item(new StandardLabel().title("i128_password  ").icon(CRUDfxIcons.i128_password))
                        .item(new StandardLabel().title("i128_paste  ").icon(CRUDfxIcons.i128_paste))
                        .item(new StandardLabel().title("i128_phone  ").icon(CRUDfxIcons.i128_phone))
                        .item(new StandardLabel().title("i128_previous  ").icon(CRUDfxIcons.i128_previous))
                        .item(new StandardLabel().title("i128_printer  ").icon(CRUDfxIcons.i128_printer))
                        .item(new StandardLabel().title("i128_quickopen  ").icon(CRUDfxIcons.i128_quickopen))
                        .item(new StandardLabel().title("i128_receive  ").icon(CRUDfxIcons.i128_receive))
                        .item(new StandardLabel().title("i128_redo  ").icon(CRUDfxIcons.i128_redo))
                        .item(new StandardLabel().title("i128_refresh  ").icon(CRUDfxIcons.i128_refresh))
                        .item(new StandardLabel().title("i128_select_all  ").icon(CRUDfxIcons.i128_select_all))
                        .item(new StandardLabel().title("i128_statistics  ").icon(CRUDfxIcons.i128_statistics))
                        .item(new StandardLabel().title("i128_system  ").icon(CRUDfxIcons.i128_system))
                        .item(new StandardLabel().title("i128_undo  ").icon(CRUDfxIcons.i128_undo))
                        .item(new StandardLabel().title("i128_up  ").icon(CRUDfxIcons.i128_up))
                        .item(new StandardLabel().title("i128_user_away  ").icon(CRUDfxIcons.i128_user_away))
                        .item(new StandardLabel().title("i128_user_invisible  ").icon(CRUDfxIcons.i128_user_invisible))
                        .item(new StandardLabel().title("i128_user_online  ").icon(CRUDfxIcons.i128_user_online))
                        .item(new StandardLabel().title("i128_users  ").icon(CRUDfxIcons.i128_users))
                        .item(new StandardLabel().title("i128_warning  ").icon(CRUDfxIcons.i128_warning))
                        .item(new StandardLabel().title("i128_wireless  ").icon(CRUDfxIcons.i128_wireless))
                        .item(new StandardLabel().title("i128_zoom  ").icon(CRUDfxIcons.i128_zoom))
			);
	    }
	return page;
	}
}
