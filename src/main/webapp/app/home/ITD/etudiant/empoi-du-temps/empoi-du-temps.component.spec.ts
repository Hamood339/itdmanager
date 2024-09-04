import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpoiDuTempsComponent } from './empoi-du-temps.component';

describe('EmpoiDuTempsComponent', () => {
  let component: EmpoiDuTempsComponent;
  let fixture: ComponentFixture<EmpoiDuTempsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EmpoiDuTempsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmpoiDuTempsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
