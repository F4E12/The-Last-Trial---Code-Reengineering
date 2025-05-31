package id.ac.binus.solution.core.states.boss;

import id.ac.binus.solution.core.interfaces.CharacterContext;

public interface BossState {
  void start(CharacterContext context);
  void update(CharacterContext context);
}