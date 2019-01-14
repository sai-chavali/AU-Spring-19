import { Directive, Input, TemplateRef, ViewContainerRef } from '@angular/core';

@Directive({
  selector: '[appTable]'
})
export class TableDirective {
  private view = false;

  constructor(private templateRef: TemplateRef<any>, private viewContainer: ViewContainerRef){}

  @Input() set appTable(cond: boolean) {
    if(cond){
      this.viewContainer.createEmbeddedView(this.templateRef);
      this.view = true
    }
    else{
      this.viewContainer.clear();
      this.view = false;
    }
  }
}
