import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TeamDeleteComponent } from './team-delete.component';

describe('TeamDeleteComponent', () => {
  let component: TeamDeleteComponent;
  let fixture: ComponentFixture<TeamDeleteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TeamDeleteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TeamDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
