import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TeamInsertComponent } from './team-insert.component';

describe('TeamInsertComponent', () => {
  let component: TeamInsertComponent;
  let fixture: ComponentFixture<TeamInsertComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TeamInsertComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TeamInsertComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
