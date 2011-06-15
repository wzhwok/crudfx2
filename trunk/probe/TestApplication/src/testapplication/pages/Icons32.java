package testapplication.pages;

import crudfx2.core.gui.control.*;
import crudfx2.core.gui.container.*;
import crudfx2.core.gui.layout.*;
import crudfxicons.*;

public class Icons32 {
    static TabPage page=null;
    public static TabPage get(){
	if(page==null){
	    page=new TabPage()
		.title("32 x 32")
		    .body(new SuiteCrowd()           
			.item(new StandardLabel().title("i32_calendar  ").icon(CRUDfxIcons.i32_calendar))
			.item(new StandardLabel().title("i32_chart  ").icon(CRUDfxIcons.i32_chart))
                        .item(new StandardLabel().title("i32_computer  ").icon(CRUDfxIcons.i32_computer))
                        .item(new StandardLabel().title("i32_copy  ").icon(CRUDfxIcons.i32_copy))
                        .item(new StandardLabel().title("i32_cut  ").icon(CRUDfxIcons.i32_cut))
                        .item(new StandardLabel().title("i32_database  ").icon(CRUDfxIcons.i32_database))
                        .item(new StandardLabel().title("i32_decrypt  ").icon(CRUDfxIcons.i32_decrypt))
                        .item(new StandardLabel().title("i32_delete  ").icon(CRUDfxIcons.i32_delete))
		    .item(new StandardLabel().title("i32_dictionary  ").icon(CRUDfxIcons.i32_dictionary))
                        .item(new StandardLabel().title("i32_down  ").icon(CRUDfxIcons.i32_down))
                        .item(new StandardLabel().title("i32_edit  ").icon(CRUDfxIcons.i32_edit))
                        .item(new StandardLabel().title("i32_favorites  ").icon(CRUDfxIcons.i32_favorites))
                        .item(new StandardLabel().title("i32_folder  ").icon(CRUDfxIcons.i32_folder))
                        .item(new StandardLabel().title("i32_folder_documents  ").icon(CRUDfxIcons.i32_folder_documents))
		    .item(new StandardLabel().title("i32_important  ").icon(CRUDfxIcons.i32_important))
		    .item(new StandardLabel().title("i32_information  ").icon(CRUDfxIcons.i32_information))
                        .item(new StandardLabel().title("i32_internet  ").icon(CRUDfxIcons.i32_internet))
                        .item(new StandardLabel().title("i32_message  ").icon(CRUDfxIcons.i32_message))
                        .item(new StandardLabel().title("i32_next  ").icon(CRUDfxIcons.i32_next))
                        .item(new StandardLabel().title("i32_ok_apply  ").icon(CRUDfxIcons.i32_ok_apply))
                        .item(new StandardLabel().title("i32_optical_data  ").icon(CRUDfxIcons.i32_optical_data))
                        .item(new StandardLabel().title("i32_password  ").icon(CRUDfxIcons.i32_password))
                        .item(new StandardLabel().title("i32_paste  ").icon(CRUDfxIcons.i32_paste))
                        .item(new StandardLabel().title("i32_phone  ").icon(CRUDfxIcons.i32_phone))
                        .item(new StandardLabel().title("i32_previous  ").icon(CRUDfxIcons.i32_previous))
                        .item(new StandardLabel().title("i32_printer  ").icon(CRUDfxIcons.i32_printer))
                        .item(new StandardLabel().title("i32_quickopen  ").icon(CRUDfxIcons.i32_quickopen))
                        .item(new StandardLabel().title("i32_receive  ").icon(CRUDfxIcons.i32_receive))
                        .item(new StandardLabel().title("i32_redo  ").icon(CRUDfxIcons.i32_redo))
                        .item(new StandardLabel().title("i32_refresh  ").icon(CRUDfxIcons.i32_refresh))
                        .item(new StandardLabel().title("i32_select_all  ").icon(CRUDfxIcons.i32_select_all))
                        .item(new StandardLabel().title("i32_statistics  ").icon(CRUDfxIcons.i32_statistics))
                        .item(new StandardLabel().title("i32_system  ").icon(CRUDfxIcons.i32_system))
                        .item(new StandardLabel().title("i32_undo  ").icon(CRUDfxIcons.i32_undo))
                        .item(new StandardLabel().title("i32_up  ").icon(CRUDfxIcons.i32_up))
                        .item(new StandardLabel().title("i32_user_away  ").icon(CRUDfxIcons.i32_user_away))
                        .item(new StandardLabel().title("i32_user_invisible  ").icon(CRUDfxIcons.i32_user_invisible))
                        .item(new StandardLabel().title("i32_user_online  ").icon(CRUDfxIcons.i32_user_online))
                        .item(new StandardLabel().title("i32_users  ").icon(CRUDfxIcons.i32_users))
                        .item(new StandardLabel().title("i32_warning  ").icon(CRUDfxIcons.i32_warning))
                        .item(new StandardLabel().title("i32_wireless  ").icon(CRUDfxIcons.i32_wireless))
                        .item(new StandardLabel().title("i32_zoom  ").icon(CRUDfxIcons.i32_zoom))
			);
	    }
	return page;
	}
    
}
