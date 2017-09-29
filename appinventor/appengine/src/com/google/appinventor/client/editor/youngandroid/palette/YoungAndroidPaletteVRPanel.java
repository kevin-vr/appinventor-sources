// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2009-2011 Google, All Rights reserved
// Copyright 2011-2017 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.client.editor.youngandroid.palette;

import com.google.appinventor.client.editor.simple.SimpleComponentDatabase;
import com.google.appinventor.client.editor.simple.palette.AbstractPalettePanel;
import com.google.appinventor.client.editor.simple.palette.SimplePalettePanel;
import com.google.appinventor.client.editor.youngandroid.YaVREditor;
import com.google.appinventor.client.wizards.ComponentImportWizard;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;

import static com.google.appinventor.client.Ode.MESSAGES;

/**
 * Panel showing Simple components which can be dropped onto the Young Android
 * visual designer panel.
 *
 * @author lizlooney@google.com (Liz Looney)
 */
public class YoungAndroidPaletteVRPanel extends AbstractPalettePanel<SimpleComponentDatabase, YaVREditor> {

  /**
   * Creates a new component palette panel.
   *
   * @param editor parent editor of this panel
   */
  public YoungAndroidPaletteVRPanel(YaVREditor editor) {
    super(editor, new YoungAndroidComponentFactory(editor));

    // If a category has a palette helper, add it to the paletteHelpers map here.
    paletteHelpers.put(ComponentCategory.LEGOMINDSTORMS, new LegoPaletteHelper());

    initExtensionPanel();
  }

  @Override
  public SimplePalettePanel copy() {
    YoungAndroidPaletteVRPanel copy = new YoungAndroidPaletteVRPanel(this.editor);
    copy.setSize("100%", "100%");
    return copy;
  }

  private void initExtensionPanel() {
    Anchor addComponentAnchor = new Anchor(MESSAGES.importExtensionMenuItem());
    addComponentAnchor.setStylePrimaryName("ode-ExtensionAnchor");
    addComponentAnchor.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        new ComponentImportWizard().center();
      }
    });

    categoryPanels.get(ComponentCategory.EXTENSION).add(addComponentAnchor);
    categoryPanels.get(ComponentCategory.EXTENSION).setCellHorizontalAlignment(
        addComponentAnchor, HasHorizontalAlignment.ALIGN_CENTER);
  }
}
