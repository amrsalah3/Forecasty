package com.narify.forecasty.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.concurrent.Executor;
import javax.annotation.Generated;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ExecutorModule_ProvideExecutorFactory implements Factory<Executor> {
  @Override
  public Executor get() {
    return provideExecutor();
  }

  public static ExecutorModule_ProvideExecutorFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Executor provideExecutor() {
    return Preconditions.checkNotNull(ExecutorModule.provideExecutor(), "Cannot return null from a non-@Nullable @Provides method");
  }

  private static final class InstanceHolder {
    private static final ExecutorModule_ProvideExecutorFactory INSTANCE = new ExecutorModule_ProvideExecutorFactory();
  }
}
