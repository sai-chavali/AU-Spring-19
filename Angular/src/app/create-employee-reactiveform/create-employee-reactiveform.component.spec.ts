import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateEmployeeReactiveformComponent } from './create-employee-reactiveform.component';

describe('CreateEmployeeReactiveformComponent', () => {
  let component: CreateEmployeeReactiveformComponent;
  let fixture: ComponentFixture<CreateEmployeeReactiveformComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateEmployeeReactiveformComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateEmployeeReactiveformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
