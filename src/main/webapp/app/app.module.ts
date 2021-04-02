import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { WoloxTestSharedModule } from 'app/shared/shared.module';
import { WoloxTestCoreModule } from 'app/core/core.module';
import { WoloxTestAppRoutingModule } from './app-routing.module';
import { WoloxTestHomeModule } from './home/home.module';
import { WoloxTestEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';

@NgModule({
  imports: [
    BrowserModule,
    WoloxTestSharedModule,
    WoloxTestCoreModule,
    WoloxTestHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    WoloxTestEntityModule,
    WoloxTestAppRoutingModule,
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent],
  bootstrap: [MainComponent],
})
export class WoloxTestAppModule {}
